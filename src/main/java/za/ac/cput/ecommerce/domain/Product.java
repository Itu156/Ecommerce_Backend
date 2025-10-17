package za.ac.cput.ecommerce.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String proName;
    private String description;
    private double price;
    private int stock;
    private String image;
    private String status;

    @ManyToOne
    @JoinColumn(name = "subcat_id", nullable = false)
    private SubCategory subCategory;

    public Product() {}

    public Product(Long productId, String proName, String description, double price, int stock, String image, String status, SubCategory subCategory) {
        this.productId = productId;
        this.proName = proName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.status = status;
        this.subCategory = subCategory;
    }



    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProName() { return proName; }
    public void setProName(String proName) { this.proName = proName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public SubCategory getSubCategory() { return subCategory; }
    public void setSubCategory(SubCategory subCategory) { this.subCategory = subCategory; }


    public static class Builder {
        private Long productId;
        private String proName;
        private String description;
        private double price;
        private int stock;
        private String image;
        private String status;
        private SubCategory subCategory;

        public Builder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProName(String proName) {
            this.proName = proName;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setSubCategory(SubCategory subCategory) {
            this.subCategory = subCategory;
            return this;
        }

        public Product build() {
            return new Product(productId, proName, description, price, stock, image, status, subCategory);
        }
    }


}
