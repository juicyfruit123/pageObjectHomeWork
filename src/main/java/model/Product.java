package model;

import java.util.Objects;
import java.util.StringJoiner;

public class Product {
    private int price;
    private int garanty;
    private String description;

    public Product(int price, int garanty, String description) {
        this.price = price + garanty;
        this.garanty = garanty;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGaranty() {
        return garanty;
    }

    public void setGaranty(int garanty) {
        this.garanty = garanty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                garanty == product.garanty &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, garanty, description);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("price=" + price)
                .add("garanty=" + garanty)
                .add("description='" + description + "'")
                .toString();
    }
}
