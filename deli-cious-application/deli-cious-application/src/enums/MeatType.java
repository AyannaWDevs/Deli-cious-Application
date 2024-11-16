package src.enums;

public enum MeatType {
    TURKEY("Turkey"),
    HAM("Ham"),
    ROAST_BEEF("Roast Beef"),
    CHICKEN("Chicken"),
    SALAMI("Salami"),
    VEGGIE("Veggie (No Meat)");

    private final String displayName;

    MeatType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // Display available meat options with numbers
    public static void displayMeatOptions() {
        System.out.println("Available Meat Types:");
        for (int i = 0; i < values().length; i++) {
            System.out.println((i + 1) + ". " + values()[i].getDisplayName());
        }
    }

    public static MeatType fromChoice(int choice) {
        return values()[choice - 1]; // Adjust for 1-based indexing
    }
}
