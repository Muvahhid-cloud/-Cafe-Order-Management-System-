import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ViewMenuPanel extends JPanel {
    public ViewMenuPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240)); // Light background for the whole panel

        // Header
        JLabel header = new JLabel("Choose a Category", JLabel.CENTER);
        header.setFont(new Font("Serif", Font.BOLD, 30));
        header.setForeground(new Color(102, 51, 0));
        add(header, BorderLayout.NORTH);

        // Panel to hold categories
        JPanel categoriesPanel = new JPanel(new GridLayout(1, 3, 20, 20)); // 3 columns
        categoriesPanel.setOpaque(false);

        // Add categories with cursor and hover effects
        addCategory(categoriesPanel, "Desserts", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\deserts\\deserts menu.jpeg", "DessertsMenu");
        addCategory(categoriesPanel, "Drinks", "path/to/drinks.jpg", "DrinksMenu");
        addCategory(categoriesPanel, "Doners", "path/to/doners.jpg", "DonersMenu");

        JScrollPane scrollPane = new JScrollPane(categoriesPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(scrollPane, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.setBackground(new Color(139, 69, 19));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        add(backButton, BorderLayout.SOUTH);
    }

    // Add a category to the panel with hover and cursor effects
    private void addCategory(JPanel panel, String name, String imagePath, String targetPanel) {
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BorderLayout());
        categoryPanel.setPreferredSize(new Dimension(330, 400)); // Adjusted height for better proportions
        categoryPanel.setBackground(new Color(255, 248, 230)); // Light cream background
        categoryPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 2)); // Brown border
        categoryPanel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor effect for the entire panel

        // Add hover effect for the entire category panel
        categoryPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                categoryPanel.setBackground(new Color(245, 222, 179)); // Lighter beige on hover
                categoryPanel.setBorder(BorderFactory.createLineBorder(new Color(160, 82, 45), 3)); // Darker border on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                categoryPanel.setBackground(new Color(255, 248, 230)); // Reset background
                categoryPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 2)); // Reset border
            }
        });

        // Title Section
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(245, 222, 179)); // Light beige background for title
        JLabel titleLabel = new JLabel(name, JLabel.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 20)); // Stylish font
        titleLabel.setForeground(new Color(101, 67, 33)); // Darker brown
        titlePanel.add(titleLabel);

        categoryPanel.add(titlePanel, BorderLayout.NORTH);

        // Category Image
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(resizeImageIcon(imagePath, 450, 400)); // Resize image
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        categoryPanel.add(imageLabel, BorderLayout.CENTER);

        // Choose Menu Button
        JButton chooseButton = new JButton("Choose Menu");
        chooseButton.setFont(new Font("Arial", Font.PLAIN, 19));
        chooseButton.setBackground(new Color(139, 69, 19)); // Coffee-brown
        chooseButton.setForeground(Color.WHITE);
        chooseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chooseButton.setFocusPainted(false);
        chooseButton.addActionListener(e -> CafeManagementSystem.switchPanel(targetPanel));
        categoryPanel.add(chooseButton, BorderLayout.SOUTH);

        panel.add(categoryPanel);
    }

    // Resize image helper method
    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
