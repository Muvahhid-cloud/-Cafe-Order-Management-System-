package com.cafemanagement.database;

import com.cafemanagement.database.models.Dish;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            DishDAO dishDAO = new DishDAO(connection);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n===== Cafe Management System =====");
                System.out.println("1. View Dishes");
                System.out.println("2. Add Dish");
                System.out.println("3. Exit");
                System.out.println("4. Make an Order");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> viewDishes(dishDAO);
                    case 2 -> addDish(dishDAO, scanner);
                    case 3 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    case 4 -> makeOrder(dishDAO, scanner);
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void viewDishes(DishDAO dishDAO) throws SQLException {
        List<Dish> dishes = dishDAO.getAllDishes();
        if (dishes.isEmpty()) {
            System.out.println("No dishes available.");
        } else {
            System.out.println("Available dishes:");
            for (Dish dish : dishes) {
                System.out.printf("ID: %d, Name: %s, Category: %s, Price: %.2f\n",
                        dish.getId(), dish.getName(), dish.getCategory(), dish.getPrice());
            }
        }
    }

    private static void addDish(DishDAO dishDAO, Scanner scanner) throws SQLException {
        System.out.print("Enter dish name: ");
        String name = scanner.nextLine();
        System.out.print("Enter dish category: ");
        String category = scanner.nextLine();
        System.out.print("Enter dish price: ");
        double price = Double.parseDouble(scanner.nextLine());

        dishDAO.addDish(new Dish(name, category, price));
        System.out.printf("Dish added: Name=%s, Category=%s, Price=%.2f\n", name, category, price);
    }

    private static void makeOrder(DishDAO dishDAO, Scanner scanner) throws SQLException {
        // Display available dishes
        List<Dish> dishes = dishDAO.getAllDishes();
        if (dishes.isEmpty()) {
            System.out.println("No dishes available for order.");
            return;
        }

        System.out.println("Available dishes:");
        for (Dish dish : dishes) {
            System.out.printf("ID: %d, Name: %s, Price: %.2f\n",
                    dish.getId(), dish.getName(), dish.getPrice());
        }

        // User selects dishes by ID
        System.out.print("Enter dish IDs (comma-separated): ");
        String[] selectedIds = scanner.nextLine().split(",");
        double totalPrice = 0;

        for (String idString : selectedIds) {
            try {
                int id = Integer.parseInt(idString.trim());
                Dish selectedDish = dishDAO.getDishById(id);
                if (selectedDish != null) {
                    totalPrice += selectedDish.getPrice();
                    System.out.printf("Added to order: %s (Price: %.2f)\n", selectedDish.getName(), selectedDish.getPrice());
                } else {
                    System.out.printf("Dish with ID %d not found.\n", id);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Invalid ID: %s. Skipping...\n", idString.trim());
            }
        }

        System.out.printf("Total price of your order: %.2f\n", totalPrice);
    }
}
//сяаиллоардо
