package za.ac.cput.ecommerce.service;

import org.springframework.stereotype.Service;
import za.ac.cput.ecommerce.domain.SubCategory;
import za.ac.cput.ecommerce.repository.SubCategoryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService implements ISubCategoryService {

    private final SubCategoryRepository repository;

    public SubCategoryService(SubCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SubCategory create(SubCategory subCategory) {
        return repository.save(subCategory);
    }

    @Override
    public SubCategory update(SubCategory subCategory) {
        return repository.save(subCategory);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<SubCategory> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SubCategory> findAll() {
        return repository.findAll();
    }
}
