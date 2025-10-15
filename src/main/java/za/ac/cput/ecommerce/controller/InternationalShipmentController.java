package za.ac.cput.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ecommerce.domain.InternationalShipment;
import za.ac.cput.ecommerce.service.InternationalShipmentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/international-shipments")
public class InternationalShipmentController {

    private final InternationalShipmentService internationalShipmentService;

    @Autowired
    public InternationalShipmentController(InternationalShipmentService internationalShipmentService) {
        this.internationalShipmentService = internationalShipmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<InternationalShipment> create(@RequestBody InternationalShipment shipment) {
        InternationalShipment created = internationalShipmentService.create(shipment);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{shipmentId}")
    public ResponseEntity<InternationalShipment> read(@PathVariable String shipmentId) {
        InternationalShipment shipment = internationalShipmentService.read(shipmentId);
        if (shipment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shipment);
    }

    @PutMapping("/update/{shipmentId}")
    public ResponseEntity<InternationalShipment> update(@PathVariable String shipmentId, @RequestBody InternationalShipment shipment) {
        InternationalShipment toUpdate = new InternationalShipment.Builder()
                .copy(shipment)
                .setShipmentId(shipmentId)
                .build();
        InternationalShipment updated = internationalShipmentService.update(toUpdate);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{shipmentId}")
    public ResponseEntity<Void> delete(@PathVariable String shipmentId) {
        if (internationalShipmentService.read(shipmentId) == null) {
            return ResponseEntity.notFound().build();
        }
        internationalShipmentService.delete(shipmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<InternationalShipment>> getAll() {
        List<InternationalShipment> shipments = internationalShipmentService.getAll();
        return ResponseEntity.ok(shipments);
    }
}
