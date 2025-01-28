package com.cafemanagement.database;

import com.cafemanagement.database.models.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private final Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new order
    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (customer_name, total_price, status) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, order.getCustomerName());
            statement.setDouble(2, order.getTotalPrice());
            statement.setString(3, order.getStatus());
            statement.executeUpdate();
        }
    }

    // Get all orders
    public List<Order> getAllOrders() throws SQLException {
        String sql = "SELECT * FROM orders";
        List<Order> orders = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getString("customer_name"),
                        resultSet.getDouble("total_price"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at").toLocalDateTime()
                );
                orders.add(order);
            }
        }
        return orders;
    }

    // Update order status
    public void updateOrderStatus(int orderId, String newStatus) throws SQLException {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newStatus);
            statement.setInt(2, orderId);
            statement.executeUpdate();
        }
    }

    // Delete an order
    public void deleteOrder(int orderId) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            statement.executeUpdate();
        }
    }
}
