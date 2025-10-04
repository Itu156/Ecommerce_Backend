package za.ac.cput.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ecommerce.domain.Shipment;
import za.ac.cput.ecommerce.service.ShipmentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    // --- NEW ENDPOINT FOR USER SHIPMENT HISTORY ---
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Shipment>> getShipmentsByUserId(@PathVariable Long userId) {
        List<Shipment> userShipments = shipmentService.findShipmentsByUserId(userId);
        return ResponseEntity.ok(userShipments);
    }

    @PostMapping("/create")
    public ResponseEntity<Shipment> create(@RequestBody Shipment shipment) {
        Shipment created = shipmentService.create(shipment);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{shipmentId}")
    public ResponseEntity<Shipment> read(@PathVariable String shipmentId) {
        Shipment shipment = shipmentService.read(shipmentId);
        if (shipment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shipment);
    }

    @PutMapping("/update/{shipmentId}")
    public ResponseEntity<Shipment> update(@PathVariable String shipmentId, @RequestBody Shipment shipment) {
        Shipment toUpdate = new Shipment.Builder()
                .copy(shipment)
                .setShipmentId(shipmentId)
                .build();
        Shipment updated = shipmentService.update(toUpdate);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{shipmentId}")
    public ResponseEntity<Void> delete(@PathVariable String shipmentId) {
        if (shipmentService.read(shipmentId) == null) {
            return ResponseEntity.notFound().build();
        }
        shipmentService.delete(shipmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Shipment>> getAll() {
        List<Shipment> shipments = shipmentService.getAll();
        return ResponseEntity.ok(shipments);
    }
}
