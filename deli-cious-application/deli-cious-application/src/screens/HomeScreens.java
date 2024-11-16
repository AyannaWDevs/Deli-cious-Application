package src.screens;

import src.enums.MeatType;

public class HomeScreens extends Screens {

    @Override
    public MeatType show() {
        System.out.println("Welcome to the Deli Application!");
        System.out.println("1. Start New Order");
        System.out.println("2. Exit");

        int choice = getUserChoice(2);
        if (choice == 1) {
            navigateToOrderScreen();
        } else {
            System.out.println("Thank you for visiting!");
        }
        return null;
    }

    @Override
    public void navigateToOrderScreen() {
        new OrderScreens().show();
    }
}
