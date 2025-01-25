import javax.swing.*;
import java.awt.*;

class MainMenuPanel extends BackgroundPanel {
    public MainMenuPanel() {
        super("C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\vecteezy_cup-of-coffee-latte-tree-shape-and-coffee-beans-on-old_28533635.jpeg"); // Set your background image path
        setLayout(new GridBagLayout());

        // Header
        JLabel header = new JLabel("Cafe Management System");
        header.setFont(new Font("Serif", Font.BOLD, 30));
        header.setForeground(new Color(102, 51, 0));
        add(header, getConstraints(0, 0, 1, 1, 20));

        // Buttons
        JButton addCoffeeButton = createStyledButton("Add Coffee");
        JButton viewMenuButton = createStyledButton("View Coffee Menu");
        JButton manageOrdersButton = createStyledButton("Manage Orders");
        JButton exitButton = createStyledButton("Exit");

        addCoffeeButton.addActionListener(e -> CafeManagementSystem.switchPanel("AddCoffee"));
        viewMenuButton.addActionListener(e -> CafeManagementSystem.switchPanel("ViewMenu"));
        manageOrdersButton.addActionListener(e -> CafeManagementSystem.switchPanel("ManageOrders"));
        exitButton.addActionListener(e -> System.exit(0));

        add(addCoffeeButton, getConstraints(0, 1, 1, 1, 10));
        add(viewMenuButton, getConstraints(0, 2, 1, 1, 10));
        add(manageOrdersButton, getConstraints(0, 3, 1, 1, 10));
        add(exitButton, getConstraints(0, 4, 1, 1, 10));
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBackground(new Color(139, 69, 19)); // Coffee-brown
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(160, 82, 45)); // Lighter coffee-brown
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(139, 69, 19)); // Original coffee-brown
            }
        });
        return button;
    }

    private GridBagConstraints getConstraints(int x, int y, int width, int height, int padding) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = new Insets(padding, padding, padding, padding);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }
}
