import javax.swing.*;
import java.awt.*;

class ViewMenuPanel extends BackgroundPanel {
    public ViewMenuPanel() {
        super("path/to/your/menu-background.jpg"); // Set your background image path
        setLayout(new BorderLayout());

        // Header
        JLabel header = new JLabel("Coffee Menu", JLabel.CENTER);
        header.setFont(new Font("Serif", Font.BOLD, 30));
        header.setForeground(new Color(102, 51, 0));
        add(header, BorderLayout.NORTH);

        // Menu Content
        JTextArea menuArea = new JTextArea(
                "1. Espresso - $3.00\n" +
                        "2. Latte - $4.00\n" +
                        "3. Cappuccino - $4.50\n" +
                        "4. Mocha - $5.00"
        );
        menuArea.setEditable(false);
        menuArea.setFont(new Font("Arial", Font.PLAIN, 18));
        menuArea.setForeground(new Color(51, 25, 0)); // Dark brown text
        menuArea.setBackground(new Color(255, 244, 230)); // Light cream background
        menuArea.setMargin(new Insets(10, 10, 10, 10));
        add(new JScrollPane(menuArea), BorderLayout.CENTER);

        // Back Button
        JButton backButton = createStyledButton("Back");
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        add(backButton, BorderLayout.SOUTH);
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
}
