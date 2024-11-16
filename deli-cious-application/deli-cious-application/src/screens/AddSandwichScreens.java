package src.screens;

import src.Sandwich;
import src.enums.*;

public class AddSandwichScreens extends Screens {
    MeatType meat = selectMeatType();

    private MeatType selectMeatType() {
        MeatType.displayMeatOptions();
        int choice = getUserChoice(MeatType.values().length);
        MeatType selectedMeat = MeatType.fromChoice(choice);
        System.out.println("Selected Meat: " + selectedMeat.getDisplayName());
        return selectedMeat;
    }

    @Override
    public MeatType show() {
        System.out.print("Select Bread Type: ");
        BreadType.displayBreadOptions();
        int choice = getUserChoice(BreadType.values().length);
        BreadType selectedBread = BreadType.fromChoice(choice);
        System.out.println("Selected Bread: " + selectedBread.getDisplayName());


        SandwichSize size = selectSandwichSize();
        boolean extraMeat = addExtraOption("Meat");
        boolean extraCheese = addExtraOption("Cheese");

        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        boolean isToasted = scanner.next().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, isToasted, extraMeat, extraCheese);

        System.out.println("Select additional toppings, type 'done' to finish:");
        String toppingInput;
        while (!(toppingInput = scanner.next()).equalsIgnoreCase("done")) {
            ToppingType topping = ToppingType.valueOf(toppingInput.toUpperCase());
            sandwich.addTopping(topping);
        }

        System.out.println("Sandwich added to order.");
        navigateToOrderScreen();
    return  selectMeatType();}


    private SandwichSize selectSandwichSize() {
        System.out.println("Select Sandwich Size:");
        System.out.println("1. Four Inch");
        System.out.println("2. Eight Inch");
        System.out.println("3. Twelve Inch");

        int choice = getUserChoice(3);
        return switch (choice) {
            case 1 -> SandwichSize.FOUR_INCH;
            case 2 -> SandwichSize.EIGHT_INCH;
            case 3 -> SandwichSize.TWELVE_INCH;
            default -> SandwichSize.EIGHT_INCH;
        };
    }

    private boolean addExtraOption(String toppingName) {
        System.out.print("Add extra " + toppingName + "? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }

    @Override
    public void navigateToOrderScreen() {
        new OrderScreens().show();
    }
}
