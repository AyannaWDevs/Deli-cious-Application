package src;

import src.enums.SandwichSize;
import src.enums.ToppingType;
import src.enums.DrinkSize;

public class Order {
    private Sandwich sandwich;
    private boolean hasChips;
    private DrinkSize drinkSize;

    // Constructor to initialize the order
    public Order(Sandwich sandwich, boolean hasChips, DrinkSize drinkSize) {
        this.sandwich = sandwich;
        this.hasChips = hasChips;
        this.drinkSize = drinkSize;
    }

    // Getters and Setters
    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public boolean hasChips() {
        return hasChips;
    }

    public void setHasChips(boolean hasChips) {
        this.hasChips = hasChips;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    // Method to calculate the total price of the order
    public double calculateTotalPrice() {
        double totalPrice = sandwich.calculateTotalPrice();

        // Add the price of chips if selected
        if (hasChips) {
            totalPrice += 1.50;
        }

        // Add the price of the drink if a size is selected
        if (drinkSize != null) {
            totalPrice += drinkSize.getPrice();
        }

        return totalPrice;
    }

    // Display order details
    @Override
    public String toString() {
        return "Order{" +
                "sandwich=" + sandwich +
                ", hasChips=" + hasChips +
                ", drinkSize=" + drinkSize +
                ", totalPrice=" + calculateTotalPrice() +
                '}';
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

}
