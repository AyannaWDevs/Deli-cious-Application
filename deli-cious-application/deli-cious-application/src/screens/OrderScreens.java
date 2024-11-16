package src.screens;

import src.Order;
import src.enums.DrinkSize;
import src.enums.MeatType;

public class OrderScreens extends Screens {
    private Order order = new Order(null, false, null);

    @Override
    public MeatType show() {
        System.out.println("Order Screen:");
        System.out.println("1. Add Sandwich");
        System.out.println("2. Add Drink");
        System.out.println("3. Add Chips");
        System.out.println("4. Checkout");
        System.out.println("5. Cancel Order");

        int choice = getUserChoice(5);
        switch (choice) {
            case 1 -> navigateToAddSandwichScreen();
            case 2 -> {
                order.setDrinkSize(selectDrinkSize());
            }
            case 3 -> order.setHasChips(true);
            case 4 -> navigateToCheckoutScreen();
            case 5 -> System.out.println("Order canceled.");
            default -> System.out.println("Invalid option, please try again.");
        }
        return null;
    }

    private DrinkSize selectDrinkSize() {
        System.out.println("Select Drink Size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        int choice = getUserChoice(3);
        return switch (choice) {
            case 1 -> DrinkSize.SMALL;
            case 2 -> DrinkSize.MEDIUM;
            case 3 -> DrinkSize.LARGE;
            default -> DrinkSize.SMALL;
        };
    }

    private void navigateToOrderScreens() {
        OrderScreens OrderScreens = new OrderScreens();
        OrderScreens.show();  // Display the OrderScreen options
    }

}
