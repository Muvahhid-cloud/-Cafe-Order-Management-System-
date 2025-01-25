import javax.swing.*;
import java.awt.*;

class ManageOrdersPanel extends BackgroundPanel {
    private JPanel ordersPanel;

    public ManageOrdersPanel() {
        super("path/to/your/orders-background.jpg"); // Set your background image path
        setLayout(new BorderLayout());

        // Header
        JLabel header = new JLabel("Manage Orders", JLabel.CENTER);
        header.setFont(new Font("Serif", Font.BOLD, 30));
        header.setForeground(new Color(102, 51, 0));
        add(header, BorderLayout.NORTH);

        // Orders List Panel
        ordersPanel = new JPanel();
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));
        ordersPanel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        add(scrollPane, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.setBackground(new Color(139, 69, 19));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        add(backButton, BorderLayout.SOUTH);

        // Update Orders
        updateOrders();
    }

    public void updateOrders() {
        ordersPanel.removeAll();

        for (OrderItem item : OrderManager.getOrders()) {
            JLabel orderLabel = new JLabel(item.getName() + " - $" + item.getPrice());
            orderLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            orderLabel.setForeground(new Color(51, 25, 0));
            ordersPanel.add(orderLabel);
        }

        JLabel totalLabel = new JLabel("Total: $" + OrderManager.getTotalPrice());
        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalLabel.setForeground(new Color(102, 51, 0));
        ordersPanel.add(totalLabel);

        ordersPanel.revalidate();
        ordersPanel.repaint();
    }
}
