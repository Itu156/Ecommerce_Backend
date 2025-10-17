package za.ac.cput.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.ecommerce.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
