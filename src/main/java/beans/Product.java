package beans;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String id;
    private String nameProduct;
    private String brandProduct;
    private String priceProduct;
    private String product_model;
    private String product_color;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrandProduct() {
        return brandProduct;
    }

    public void setBrandProduct(String brandProduct) {
        this.brandProduct = brandProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getProduct_model() {
        return product_model;
    }

    public void setProduct_model(String product_model) {
        this.product_model = product_model;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(brandProduct, product.brandProduct) &&
                Objects.equals(priceProduct, product.priceProduct) &&
                Objects.equals(product_model, product.product_model) &&
                Objects.equals(product_color, product.product_color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, brandProduct, priceProduct, product_model, product_color);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", brandProduct='" + brandProduct + '\'' +
                ", priceProduct='" + priceProduct + '\'' +
                ", product_model='" + product_model + '\'' +
                ", product_color='" + product_color + '\'' +
                '}';
    }
}
