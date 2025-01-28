package com.cafemanagement.database;

import com.cafemanagement.database.models.Dish;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class DatabaseInitializer {

    public void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            createTables(connection);
            populateDishes(connection);
            System.out.println("Database initialized successfully!");
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

    // Метод для создания таблиц
    private void createTables(Connection connection) {
        String createDishesTableSQL = "CREATE TABLE IF NOT EXISTS dishes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "category TEXT NOT NULL, " +
                "price REAL NOT NULL" +
                ");";

        String createOrdersTableSQL = "CREATE TABLE IF NOT EXISTS orders (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "customer_name TEXT NOT NULL, " +
                "total_price REAL NOT NULL, " +
                "status TEXT NOT NULL, " +
                "created_at TEXT DEFAULT CURRENT_TIMESTAMP" +
                ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createDishesTableSQL);
            System.out.println("Table 'dishes' created successfully!");

            statement.execute(createOrdersTableSQL);
            System.out.println("Table 'orders' created successfully!");
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }

    // Метод для заполнения таблицы dishes начальными данными
    private void populateDishes(Connection connection) {
        DishDAO dishDAO = new DishDAO(connection);

        List<Dish> dishes = Arrays.asList(
                new Dish("Margherita Pizza", "Main Course", 8.99),
                new Dish("Caesar Salad", "Salad", 6.50),
                new Dish("Spaghetti Bolognese", "Main Course", 9.99),
                new Dish("Mushroom Soup", "Soup", 5.75),
                new Dish("Chicken Curry", "Main Course", 10.50),
                new Dish("Cappuccino", "Beverage", 3.25),
                new Dish("Espresso", "Beverage", 2.75),
                new Dish("Chocolate Cake", "Dessert", 4.50),
                new Dish("Grilled Cheese Sandwich", "Snack", 4.99),
                new Dish("Orange Juice", "Beverage", 2.99),
                new Dish("BBQ Sauce", "Sauce", 1.25),
                new Dish("Ketchup", "Sauce", 1.00),
                new Dish("Vanilla Ice Cream", "Dessert", 3.75),
                new Dish("Cheeseburger", "Main Course", 7.99),
                new Dish("Latte", "Beverage", 3.50),
                new Dish("Tomato Soup", "Soup", 4.99),
                new Dish("Fish Tacos", "Main Course", 8.25),
                new Dish("Hot Chocolate", "Beverage", 3.00),
                new Dish("Pesto Pasta", "Main Course", 9.50),
                new Dish("Garlic Bread", "Snack", 3.75)
        );

        try {
            for (Dish dish : dishes) {
                dishDAO.addDish(dish);
            }
            System.out.println("Initial dishes added to the database!");
        } catch (SQLException e) {
            System.err.println("Error populating dishes: " + e.getMessage());
        }
    }
}
