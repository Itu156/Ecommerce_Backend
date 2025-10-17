package za.ac.cput.ecommerce.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cateId;

    private String catName;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubCategory> subCategories = new HashSet<>();

    public Category() {}

    public Category(Long cateId, String catName, String description, Set<SubCategory> subCategories) {
        this.cateId = cateId;
        this.catName = catName;
        this.description = description;
        this.subCategories = subCategories;
    }

    // ----------- Getters & Setters -----------
    public Long getCateId() { return cateId; }
    public void setCateId(Long cateId) { this.cateId = cateId; }

    public String getCatName() { return catName; }
    public void setCatName(String catName) { this.catName = catName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Set<SubCategory> getSubCategories() { return subCategories; }
    public void setSubCategories(Set<SubCategory> subCategories) { this.subCategories = subCategories; }


    // ----------- Builder Pattern -----------
    public static class Builder {
        private Long cateId;
        private String catName;
        private String description;
        private Set<SubCategory> subCategories = new HashSet<>();

        public Builder setCateId(Long cateId) {
            this.cateId = cateId;
            return this;
        }

        public Builder setCatName(String catName) {
            this.catName = catName;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder addSubCategory(SubCategory subCategory) {
            this.subCategories.add(subCategory);
            return this;
        }

        public Category build() {
            return new Category(cateId, catName, description, subCategories);
        }
    }


}

