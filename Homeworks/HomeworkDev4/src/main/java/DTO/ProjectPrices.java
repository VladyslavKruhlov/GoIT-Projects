package DTO;

public class ProjectPrices {
    String name ;
    int price;

    public ProjectPrices(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}