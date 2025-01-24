import javax.swing.*;
import java.awt.*;

class MainMenuPanel extends JPanel {
    public MainMenuPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 240, 240)); // Optional background color

        // Header
        JLabel header = new JLabel("Cafe Management System");
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(93, 64, 55));
        add(header, getConstraints(0, 0, 1, 1, 10));

        // Buttons
        JButton addCoffeeButton = createStyledButton("Add Coffee Item");
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
        button.setBackground(new Color(93, 64, 55));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
