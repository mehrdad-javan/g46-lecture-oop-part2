package se.lexicon.data;

import se.lexicon.model.Product;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public interface IOrder {
    // cannot define instance fields

    int MAX_ITEM = 10;

    Product[] getItems();

    void removeItem(Product item);

    void addItem(Product item);

    default double calculatePrice() {
        double total = 0;
        for (Product item : getItems()) {
            total += item.getPrice();
        }
        return total;
    }

    default double calculatePriceWithTax() {
        double total = 0;
        for (Product item : getItems()) {
            total += item.getPrice() + item.calculateTaxes();
        }

        DecimalFormat df = new DecimalFormat("#.##"); // Specify the format pattern
        df.setRoundingMode(RoundingMode.HALF_UP); // Specify the rounding mode

        String formattedNumber = df.format(total);
        return Double.parseDouble(formattedNumber);
    }

    default void displayItems() {
        int counter = 1;
        for (Product item : getItems()) {
            System.out.println("ORDER [" + counter++ + "]----------------");
            item.displayInfo();
        }

        System.out.println("#############################");
        System.out.println("Total Order Cost: " + calculatePrice());
        System.out.println("Total Order Cost With Tax: " + calculatePriceWithTax());
        System.out.println("#############################");
    }

    // sometimes we can define default and static methods
}
