package za.ac.cput.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.ecommerce.domain.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {}