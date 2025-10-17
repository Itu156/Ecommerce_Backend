package za.ac.cput.ecommerce.service;


import za.ac.cput.ecommerce.domain.SubCategory;

import java.util.List;
import java.util.Optional;

public interface ISubCategoryService {
    SubCategory create(SubCategory subCategory);
    SubCategory update(SubCategory subCategory);
    void delete(Long id);
    Optional<SubCategory> findById(Long id);
    List<SubCategory> findAll();
}

