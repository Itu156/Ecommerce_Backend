package za.ac.cput.ecommerce.repository;

/*
InternationalShipmentRepository.java
InternationalShipment Repository Interface
Author: Dean Jantjies 222644702
Date: 11 May 2025
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.ecommerce.domain.InternationalShipment;

import java.util.List;

@Repository
public interface InternationalShipmentRepository extends JpaRepository<InternationalShipment, String> {
    List<InternationalShipment> findByCustomsDeclarationNumberContainingIgnoreCase(String customsDeclarationNumber);
}

