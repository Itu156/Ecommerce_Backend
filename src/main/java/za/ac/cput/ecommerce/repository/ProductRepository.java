package za.ac.cput.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.ecommerce.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
