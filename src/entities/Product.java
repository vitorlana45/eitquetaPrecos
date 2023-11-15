package entities;

import java.text.SimpleDateFormat;

public class Product {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private Double price;

    public Product() {
        super();
    }

    public Product(String name, Double price) {
        super();
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String priceTag() {

        return getName()
                + ": $"
                + String.format("%.2f", getPrice()) + " REAIS ";
    }
}
