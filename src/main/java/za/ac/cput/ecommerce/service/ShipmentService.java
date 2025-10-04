package za.ac.cput.ecommerce.service;

import za.ac.cput.ecommerce.domain.Shipment;

import java.util.List;

public interface ShipmentService extends IService<Shipment, String> {


    List<Shipment> findShipmentsByUserId(Long userId);

    boolean delete(String shipmentId);

    List<Shipment> getAll();
}

