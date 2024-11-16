package src.enums;

public enum SandwichSize {
    FOUR_INCH(5.50),
    EIGHT_INCH(7.00),
    TWELVE_INCH(8.50);

    // Stores sandwich base price by size
    private final double basePrice;

    SandwichSize(double basePrice) {
        this.basePrice = basePrice;
    }

    //calculates extra charge based on the size for extra toppings\
    //when isAdditional is true,the first set of pricing rules is used
    //? is called the ternary conditional operator. Here, it checks the sandwich size and returns a price based on
    //that size using a switch statement
    //condition ? valueIfTrue: valueIfFalse
    public double calculateExtraPrice(String extraType, boolean isAdditional) {
        return switch (extraType) {
            case "MEAT" -> isAdditional
                    ? (this == FOUR_INCH ? 0.50 : this == EIGHT_INCH ? 1.00 : 1.50)
                    : (this == FOUR_INCH ? 1.00 : this == EIGHT_INCH ? 2.00 : 3.00);
            case "CHEESE" -> isAdditional
                    ? (this == FOUR_INCH ? 0.30 : this == EIGHT_INCH ? 0.60 : 0.90)
                    : (this == FOUR_INCH ? 0.75 : this == EIGHT_INCH ? 1.50 : 2.25);
            default -> 0;
        };
    }
    // Getter for base price
    public double getBasePrice() {
        return basePrice;

    }
}
