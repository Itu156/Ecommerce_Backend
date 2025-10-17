package za.ac.cput.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ecommerce.domain.SubCategory;
import za.ac.cput.ecommerce.service.SubCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {

    private final SubCategoryService service;

    public SubCategoryController(SubCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SubCategory> create(@RequestBody SubCategory subCategory) {
        return ResponseEntity.ok(service.create(subCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategory> update(@PathVariable Long id, @RequestBody SubCategory subCategory) {
        subCategory.setSubcatId(id);
        return ResponseEntity.ok(service.update(subCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategory> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SubCategory>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}