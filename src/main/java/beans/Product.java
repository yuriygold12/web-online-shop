package beans;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String nameProduct;
    private String markaProduct;
    private LocalDate date;
    private LocalDate end_datasecond;
    private LocalDate end_date;

    public LocalDate getEnd_datasecond() {
        return end_datasecond;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_datasecond(LocalDate end_datasecond) {

        this.end_datasecond = end_datasecond;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Product() {
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getMarkaProduct() {
        return markaProduct;
    }

    public void setMarkaProduct(String markaProduct) {
        this.markaProduct = markaProduct;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(markaProduct, product.markaProduct) &&
                Objects.equals(date, product.date) &&
                Objects.equals(end_datasecond, product.end_datasecond) &&
                Objects.equals(end_date, product.end_date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameProduct, markaProduct, date, end_datasecond, end_date);
    }


    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", markaProduct='" + markaProduct + '\'' +
                ", date=" + date +
                ", end_datasecond=" + end_datasecond +
                ", end_date=" + end_date +
                '}';
    }
}
