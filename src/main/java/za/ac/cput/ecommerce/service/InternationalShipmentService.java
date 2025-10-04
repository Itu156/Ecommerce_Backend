package za.ac.cput.ecommerce.service;

/*
InternationalShipmentService.java
InternationalShipment Service Interface
Author: Dean Jantjies 222644702
Date: 11 May 2025
*/



import za.ac.cput.ecommerce.domain.InternationalShipment;

import java.util.List;

public interface InternationalShipmentService {

    InternationalShipment create(InternationalShipment shipment);

    InternationalShipment read(String shipmentId);

    InternationalShipment update(InternationalShipment shipment);

    boolean delete(String shipmentId);

    List<InternationalShipment> getAll();
}
