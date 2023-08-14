package se.lexicon.data;

import se.lexicon.model.Product;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class Order implements IOrder {

    private String orderId;
    private LocalDateTime dateTime;
    private Product[] items;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.dateTime = LocalDateTime.now();
        this.items = new Product[0];
    }


    @Override
    public Product[] getItems() {
        return Arrays.copyOf(items, items.length);
    }

    @Override
    public void removeItem(Product item) {
        //todo: implement the logic
    }

    @Override
    public void addItem(Product item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null.");
        Product[] newArray = Arrays.copyOf(items, items.length + 1 );
        newArray[newArray.length - 1] = item;
        items = newArray;
    }

    @Override
    public void displayItems() {
        int counter = 1;
        for (Product item: getItems()){
            System.out.println("ORDER ["+ counter++ +"]----------------");
            item.displayInfo();
        }

        System.out.println("#############################");
        System.out.println("Total Order Cost: " + calculatePrice());
        System.out.println("Total Order Cost With Tax: " + calculatePriceWithTax());
        System.out.println("ORDER ID: " + orderId);
        System.out.println("ORDER Date Time: " + dateTime);
        System.out.println("#############################");

    }


}
