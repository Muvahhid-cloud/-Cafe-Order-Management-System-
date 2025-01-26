import javax.swing.*;
import java.awt.*;

class ManageOrdersPanel extends BackgroundPanel {
    private static JPanel ordersPanel;

    public ManageOrdersPanel() {
        super("path/to/orders-background.jpg"); // Set your background image path
        setLayout(new BorderLayout());

        // Header with subtle brown background and border
        JLabel header = new JLabel("Manage Orders", JLabel.CENTER);
        header.setFont(new Font("Serif", Font.BOLD, 30));
        header.setForeground(new Color(102, 51, 0)); // Dark brown text color
        header.setOpaque(true);
        header.setBackground(new Color(245, 222, 179)); // Slightly brown background
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(160, 82, 45))); // Subtle brown bottom border
        add(header, BorderLayout.NORTH);

        // Orders List Panel
        ordersPanel = new JPanel();
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));
        ordersPanel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding around the orders list
        add(scrollPane, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBackground(new Color(139, 69, 19));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        add(backButton, BorderLayout.SOUTH);

        // Update Orders
        updateOrders();
    }

    public static void updateOrders() {
        ordersPanel.removeAll();

        for (OrderItem item : OrderManager.getOrders()) {
            // Display order item with price in green
            String orderText = String.format(
                    "<html>%s - <span style='color:rgb(34,139,34);'>$%.2f</span></html>",
                    item.getName(), item.getPrice()
            );
            JLabel orderLabel = new JLabel(orderText);
            orderLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            ordersPanel.add(orderLabel);
        }

        // Total Label with Grey Top Border
        double totalPrice = OrderManager.getTotalPrice();
        String totalText = String.format(
                "<html>Total: <span style='color:rgb(34,139,34);'>$%.2f</span></html>",
                totalPrice
        );
        JLabel totalLabel = new JLabel(totalText, JLabel.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalLabel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.GRAY)); // Grey top border
        ordersPanel.add(Box.createVerticalStrut(20)); // Add spacing above the total
        ordersPanel.add(totalLabel);

        ordersPanel.revalidate();
        ordersPanel.repaint();
    }
}
