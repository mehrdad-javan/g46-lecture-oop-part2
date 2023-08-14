package se.lexicon.model;

public class Burger extends Product {

    private String type;

    public Burger(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }

    @Override
    public double calculateTaxes() {
        return getPrice() * 0.1;
    }

}
