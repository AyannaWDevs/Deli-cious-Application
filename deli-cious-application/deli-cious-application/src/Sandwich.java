package src;

import src.enums.BreadType;
import src.enums.RegularToppings;
import src.enums.SandwichSize;
import src.enums.ToppingType;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private List<ToppingType> toppings;
    private boolean isToasted;
    private boolean extraMeat;
    private boolean extraCheese;

    // Constructor to initialize sandwich with a size and optional properties
    public Sandwich(SandwichSize size, boolean isToasted, boolean extraMeat, boolean extraCheese) {
        this.size = size;
        this.toppings = new ArrayList<>();
        this.isToasted = isToasted;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
    }

    public Sandwich(BreadType bread, SandwichSize size) {
    }

    // Add a topping to the sandwich
    public void addTopping(ToppingType topping) {
        toppings.add(topping);
    }

    // Getters and Setters
    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public List<ToppingType> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public boolean hasExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean hasExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    // Method to calculate the total price of the sandwich
    public double calculateTotalPrice() {
        double basePrice = size.getBasePrice();  // Assume getBasePrice() method exists in SandwichSize
        double toppingsPrice = 0.0;

        // Calculate price for each topping, passing in `extraMeat` and `extraCheese` flags where needed
        for (ToppingType topping : toppings) {
            if (topping == ToppingType.MEAT) {
                toppingsPrice += topping.getPrice(size, extraMeat);
            } else if (topping == ToppingType.CHEESE) {
                toppingsPrice += topping.getPrice(size, extraCheese);
            } else {
                toppingsPrice += topping.getPrice(size, false);  // Regular price for non-extra toppings
            }
        }

        return basePrice + toppingsPrice;
    }

}
