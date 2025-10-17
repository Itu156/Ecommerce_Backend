package za.ac.cput.ecommerce.service;

import za.ac.cput.ecommerce.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);
    Optional<Product> findById(Long id);
    List<Product> findAll();
}
