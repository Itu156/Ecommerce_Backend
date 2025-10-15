package za.ac.cput.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ecommerce.domain.Shipment;
import za.ac.cput.ecommerce.repository.ShipmentRepository;
import za.ac.cput.ecommerce.service.ShipmentService;


import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Shipment create(Shipment shipment) {

        Shipment toSave = ShipmentFactory.createShipment(
                shipment.getUser(),
                shipment.getOrderId(),
                shipment.getDeliveryAddress(),
                shipment.getDeliveryStatus(),
                shipment.getCarrierName(),
                shipment.getTrackingNumber(),
                shipment.getEstimatedDeliveryDate(),
                shipment.getRecipientName(),
                shipment.getContactNumber()
        );

        if (toSave == null) {
            return null;
        }

        return repository.save(toSave);
    }

    @Override
    public Shipment read(String shipmentId) {
        return repository.findById(shipmentId).orElse(null);
    }

    @Override
    public Shipment update(Shipment shipment) {
        if (repository.existsById(shipment.getShipmentId())) {
            return repository.save(shipment);
        }
        return null;
    }

    @Override
    public boolean delete(String shipmentId) {
        if (repository.existsById(shipmentId)) {
            repository.deleteById(shipmentId);
            return true;
        }
        return false;
    }

    @Override
    public List<Shipment> findShipmentsByUserId(Long userId) {
        return repository.findByUser_UserId(userId);
    }

    @Override
    public List<Shipment> getAll() {
        return repository.findAll();
    }
}

