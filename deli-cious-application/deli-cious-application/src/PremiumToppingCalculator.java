package src;

import src.enums.SandwichSize;

public class PremiumToppingCalculator {

    // Calculates the base price of meat based on the sandwich size
    public static double getBaseMeatPrice(SandwichSize size) {
        return switch (size) {
            case FOUR_INCH -> 1.00;
            case EIGHT_INCH -> 2.00;
            case TWELVE_INCH -> 3.00;
        };
    }

    // Calculates the base price of cheese based on the sandwich size
    public static double getBaseCheesePrice(SandwichSize size) {
        return switch (size) {
            case FOUR_INCH -> 0.75;
            case EIGHT_INCH -> 1.50;
            case TWELVE_INCH -> 2.25;
        };
    }

    // Calculates the extra price for meat based on the sandwich size and isAdditional flag
    public static double calculateExtraMeatPrice(SandwichSize size, boolean isAdditional) {
        return isAdditional
                ? switch (size) {
            case FOUR_INCH -> 0.50;
            case EIGHT_INCH -> 1.00;
            case TWELVE_INCH -> 1.50;
        }
                : getBaseMeatPrice(size); // Returns the base meat price if not additional
    }

    // Calculates the extra price for cheese based on the sandwich size and isAdditional flag
    public static double calculateExtraCheesePrice(SandwichSize size, boolean isAdditional) {
        return isAdditional
                ? switch (size) {
            case FOUR_INCH -> 0.30;
            case EIGHT_INCH -> 0.60;
            case TWELVE_INCH -> 0.90;
        }
                : getBaseCheesePrice(size); // Returns the base cheese price if not additional
    }
}
