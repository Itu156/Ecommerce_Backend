package za.ac.cput.ecommerce.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcatId;

    private String subcatName;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "cate_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

    public SubCategory() {}

    public SubCategory(Long subcatId, String subcatName, String description, String image, Category category, Set<Product> products) {
        this.subcatId = subcatId;
        this.subcatName = subcatName;
        this.description = description;
        this.image = image;
        this.category = category;
        this.products = products;
    }

    // ----------- Getters & Setters -----------
    public Long getSubcatId() { return subcatId; }
    public void setSubcatId(Long subcatId) { this.subcatId = subcatId; }

    public String getSubcatName() { return subcatName; }
    public void setSubcatName(String subcatName) { this.subcatName = subcatName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Set<Product> getProducts() { return products; }
    public void setProducts(Set<Product> products) { this.products = products; }


    // ----------- Builder Pattern -----------
    public static class Builder {
        private Long subcatId;
        private String subcatName;
        private String description;
        private String image;
        private Category category;
        private Set<Product> products = new HashSet<>();

        public Builder setSubcatId(Long subcatId) {
            this.subcatId = subcatId;
            return this;
        }

        public Builder setSubcatName(String subcatName) {
            this.subcatName = subcatName;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder addProduct(Product product) {
            this.products.add(product);
            return this;
        }

        public SubCategory build() {
            return new SubCategory(subcatId, subcatName, description, image, category, products);
        }
    }

}

