package src.screens;

import src.Order;
import src.enums.MeatType;

public class CheckoutScreens extends Screens {

    @Override
    public MeatType show() {
        Order order = new Order(null, false, null);  // Replace with actual order object if needed
        System.out.println("Checkout Screen:");
        System.out.println("Your order details:");
        System.out.println(order);  // Display order details

        System.out.println("1. Confirm Order");
        System.out.println("2. Cancel Order");

        int choice = getUserChoice(2);
        if (choice == 1) {
            System.out.println("Order confirmed. Generating receipt...");
            // Code to create receipt file
        } else {
            System.out.println("Order canceled.");
            navigateToOrderScreen();
        }
        return null;
    }

    @Override
    public void navigateToOrderScreen() {
        new OrderScreens().show();
    }
}
