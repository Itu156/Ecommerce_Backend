package za.ac.cput.ecommerce.service.impl;

/*
InternationalShipmentServiceImpl.java
InternationalShipment Service Implementation
Author: Dean Jantjies 222644702
Date: 11 May 2025
*/

import org.springframework.stereotype.Service;
import za.ac.cput.ecommerce.domain.InternationalShipment;
import za.ac.cput.ecommerce.repository.InternationalShipmentRepository;
import za.ac.cput.ecommerce.service.InternationalShipmentService;
import java.util.List;
import java.util.Optional;

@Service
public class InternationalShipmentServiceImpl implements InternationalShipmentService {

    private final InternationalShipmentRepository repository;

    public InternationalShipmentServiceImpl(InternationalShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public InternationalShipment create(InternationalShipment shipment) {
        return repository.save(shipment);
    }

    @Override
    public InternationalShipment read(String shipmentId) {
        Optional<InternationalShipment> shipment = repository.findById(shipmentId);
        return shipment.orElse(null);
    }

    @Override
    public InternationalShipment update(InternationalShipment shipment) {
        if(repository.existsById(shipment.getShipmentId())){
            return repository.save(shipment);
        }
        return null;
    }

    @Override
    public boolean delete(String shipmentId) {
        if(repository.existsById(shipmentId)){
            repository.deleteById(shipmentId);
            return true;
        }
        return false;
    }

    @Override
    public List<InternationalShipment> getAll() {
        return repository.findAll();
    }
}

