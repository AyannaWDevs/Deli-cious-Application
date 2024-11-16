package src;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    // Method to save order details to a uniquely named receipt file
    public void saveOrderReceipt(Order order) {
        // Format the current date and time for file naming
        LocalDateTime now = LocalDateTime.now();
        String fileName = "Receipt_" + now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            // Write the receipt details
            writer.write("Receipt\n");
            writer.write("Date & Time: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("Order Details:\n");

            if (order.getSandwich() != null) {
                writer.write("Sandwich:\n" + order.getSandwich().toString() + "\n");
            }
            if (order.hasChips()) {
                writer.write("Chips: Yes (1.50)\n");
            } else {
                writer.write("Chips: No\n");
            }
            if (order.getDrinkSize() != null) {
                writer.write("Drink Size: " + order.getDrinkSize() + " (" + order.getDrinkSize().getPrice() + ")\n");
            } else {
                writer.write("Drink: No\n");
            }

            // Calculate and display the total
            writer.write("Total Price: $" + String.format("%.2f", order.calculateTotalPrice()) + "\n");
            System.out.println("Receipt saved as " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving the receipt file.");
            e.printStackTrace();
        }
    }
}
