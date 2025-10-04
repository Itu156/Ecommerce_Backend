package za.ac.cput.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.ecommerce.domain.Shipment;
import za.ac.cput.ecommerce.domain.enums.DeliveryStatus;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {

    List<Shipment> findByUser_UserId(Long userId);

    List<Shipment> findByDeliveryStatus(DeliveryStatus deliveryStatus);

    List<Shipment> findByCarrierNameContainingIgnoreCase(String carrierName);
}
