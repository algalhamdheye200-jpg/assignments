package com.smartstore.billing;

import java.util.Scanner;

// SmartStore console billing application (refactored version).
public class BillingApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = input.nextLine();

        System.out.print("Enter product name: ");
        String productName = input.nextLine();

        System.out.print("Enter product price (Rs.): ");
        double price = input.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        input.close();

        double total = price * quantity;
        double discountAmount = calculateDiscount(total);
        double finalAmount = total - discountAmount;
        double discountPercent = getDiscountPercent(total);

        printBill(customerName, productName, price, quantity, total,
                discountPercent, discountAmount, finalAmount);
    }

    // Returns the discount percentage for a purchase total.
    // Below Rs. 1,000 -> 0%, Rs. 1,000 up to (not including) Rs. 5,000 -> 5%,
    // Rs. 5,000 and above -> 10%.
    public static double getDiscountPercent(double totalAmount) {
        if (totalAmount < 1000) {
            return 0;
        } else if (totalAmount < 5000) {
            return 5;
        } else {
            return 10;
        }
    }

    // Returns the discount amount in rupees for a purchase total.
    public static double calculateDiscount(double totalAmount) {
        return totalAmount * getDiscountPercent(totalAmount) / 100;
    }

    // Prints the bill in the format used by the case study.
    public static void printBill(String customerName, String productName, double price,
                                 int quantity, double total, double discountPercent,
                                 double discountAmount, double finalAmount) {
        System.out.println("========== CUSTOMER BILL - SMARTSTORE ==========");
        System.out.println("Customer : " + customerName);
        System.out.println("Product : " + productName);
        System.out.printf("Price : Rs. %.2f%n", price);
        System.out.println("Quantity : " + quantity);
        System.out.printf("Total : Rs. %.2f%n", total);
        System.out.printf("Discount : %.0f%%%n", discountPercent);
        System.out.printf("Discount amount : Rs. %.2f%n", discountAmount);
        System.out.println("-----------------------------------------------");
        System.out.printf("Final amount : Rs. %.2f%n", finalAmount);
        System.out.println("===============================================");
    }
}
