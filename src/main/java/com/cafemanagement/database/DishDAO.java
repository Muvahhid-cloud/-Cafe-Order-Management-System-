package com.cafemanagement.database;

import com.cafemanagement.database.models.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {
    private final Connection connection;

    public DishDAO(Connection connection) {
        this.connection = connection;
    }

    public void addDish(Dish dish) throws SQLException {
        String sql = "INSERT INTO dishes (name, category, price) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dish.getName());
            statement.setString(2, dish.getCategory());
            statement.setDouble(3, dish.getPrice());
            statement.executeUpdate();
        }
    }

    public List<Dish> getAllDishes() throws SQLException {
        String sql = "SELECT * FROM dishes";
        List<Dish> dishes = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Dish dish = new Dish(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price")
                );
                dishes.add(dish);
            }
        }
        return dishes;
    }

    // Метод для получения блюда по ID
    public Dish getDishById(int id) throws SQLException {
        String sql = "SELECT * FROM dishes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Dish(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("category"),
                            resultSet.getDouble("price")
                    );
                } else {
                    return null; // Если блюдо с таким ID не найдено
                }
            }
        }
    }
}
