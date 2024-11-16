package src.screens;

import src.enums.MeatType;

import java.util.Scanner;

public abstract class Screens {
    protected Scanner scanner = new Scanner(System.in);

    // Abstract method to display each screen's UI
    public abstract MeatType show();

    // Common method to handle user selection
    protected int getUserChoice(int optionsCount) {
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice > optionsCount) {
                System.out.println("Invalid choice. Please select between 1 and " + optionsCount);
            }
        } while (choice < 1 || choice > optionsCount);
        return choice;
    }

    // Placeholder navigation methods
    public void navigateToOrderScreen() {}
    public void navigateToAddSandwichScreen() {}
    public void navigateToCheckoutScreen() {}
}
