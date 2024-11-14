package src.enums;

public enum DrinkSize {
    SMALL(2.00),
    MEDIUM(2.50),
    LARGE(3.00);

    private double drinkPrice;

    DrinkSize(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public double getPrice() {
        return drinkPrice;
    }
}
