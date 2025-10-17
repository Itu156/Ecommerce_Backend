package za.ac.cput.ecommerce.service;


import za.ac.cput.ecommerce.domain.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Category create(Category category);
    Category update(Category category);
    void delete(Long id);
    Optional<Category> findById(Long id);
    List<Category> findAll();
}
