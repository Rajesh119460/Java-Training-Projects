package personalexpensetracker;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseService service = new ExpenseService();
        int choice;

        

        do {

            System.out.println("\n--- PERSONAL EXPENSE TRACKER ---");
            System.out.println("1. Add Expense");
            System.out.println("2. Display All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Calculate Total Expense");
            System.out.println("5. Find Highest Expense");
            System.out.println("6. Category-wise Expenses");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
             choice = sc.nextInt();

            switch (choice) {

            // Adding the  Expense
            case 1:

                System.out.print("Enter Expense ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Description: ");
                String description = sc.nextLine();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                System.out.println("Choose Category:");
                System.out.println("1. FOOD");
                System.out.println("2. TRAVEL");
                System.out.println("3. SHOPPING");
                System.out.println("4. BILLS");
                System.out.println("5. ENTERTAINMENT");
                System.out.println("6. OTHER");

                System.out.print("Enter category choice: ");
                int categoryChoice = sc.nextInt();

                Category category;

                switch (categoryChoice) {

                case 1:
                    category = Category.FOOD;
                    break;

                case 2:
                    category = Category.TRAVEL;
                    break;

                case 3:
                    category = Category.SHOPPING;
                    break;

                case 4:
                    category = Category.BILLS;
                    break;

                case 5:
                    category = Category.ENTERTAINMENT;
                    break;

                default:
                    category = Category.OTHER;
                }

                Expense expense = new Expense(
                        id,
                        description,
                        amount,
                        category,
                        LocalDate.now()
                );

                service.addExpense(expense);

                break;


            // Display All Expenses
            case 2:

                service.displayExpenses();

                break;


            // Delete Expense
            case 3:

                System.out.print("Enter Expense ID to delete: ");
                int deleteId = sc.nextInt();

                service.deleteExpenses(deleteId);

                break;


            // Calculate Total Expense
            case 4:

                double total = service.totalExpenses();

                System.out.println("Total Expense: ₹" + total);

                break;


            // Finding Highest Expense
            case 5:

                Expense highest = service.highestAmount();

                if (highest == null) {

                    System.out.println("No expenses found.");

                } else {

                    System.out.println("Highest Expense:");
                    System.out.println("ID: " + highest.getId());
                    System.out.println("Description: " + highest.getDescription());
                    System.out.println("Amount: ₹" + highest.getAmount());
                    System.out.println("Category: " + highest.getCategory());
                    System.out.println("Date: " + highest.getDate());
                }

                break;


            // Categorywise Expenses
            case 6:

                Map<Category, Double> categoryTotals =
                        service.categoryWiseExpense();

                if (categoryTotals.isEmpty()) {

                    System.out.println("No expenses found.");

                } else {

                    System.out.println("Category-wise Expenses:");

                    for (Map.Entry<Category, Double> entry :
                            categoryTotals.entrySet()) {

                        System.out.println(
                                entry.getKey() + " : ₹" + entry.getValue()
                        );
                    }
                }

                break;

            case 7:

                System.out.println("Thank you for using Expense Tracker!");

                break;


            default:

                System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}