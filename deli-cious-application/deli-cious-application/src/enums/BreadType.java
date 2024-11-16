package src.enums;

public enum BreadType {
    WHITE("White"),
    WHOLE_WHEAT("Whole Wheat"),
    MULTIGRAIN("Multigrain"),
    RYE("Rye"),
    ITALIAN("Italian");

    private final String displayName;

    BreadType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static void displayBreadOptions() {
        System.out.println("Available Bread Types:");
        for (int i = 0; i < values().length; i++) {
            System.out.println((i + 1) + ". " + values()[i].getDisplayName());
        }
    }

    public static BreadType fromChoice(int choice) {
        return values()[choice - 1]; // Adjust for 1-based indexing
    }
}
