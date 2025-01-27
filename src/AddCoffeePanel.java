import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class AddCoffeePanel extends BackgroundPanel {
    public AddCoffeePanel() {
        super("C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\coffee-beans-background.jpg"); // Set your background image path
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);

        JLabel header = new JLabel("Select Your Coffee");
        header.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30)); // Italic and bold font style
        header.setForeground(new Color(102, 51, 0));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add spacing around header
        headerPanel.add(header, BorderLayout.CENTER);

        // Add grey line under the title
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(169, 169, 169)); // Grey color for the line
        separator.setPreferredSize(new Dimension(1, 2)); // Thin line
        headerPanel.add(separator, BorderLayout.SOUTH);

        add(headerPanel, BorderLayout.NORTH);

        // Coffee Variants
        JPanel coffeePanel = new JPanel(new GridLayout(0, 3, 20, 20)); // 3 columns, spacing between items
        coffeePanel.setOpaque(false);

        // Add coffee items
        addCoffeeItem(coffeePanel, "Espresso", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\espresso.jpeg", 3.00);
        addCoffeeItem(coffeePanel, "Latte", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\lattes.jpeg", 4.50);
        addCoffeeItem(coffeePanel, "Cappuccino", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\capucino.jpeg", 5.00);
        addCoffeeItem(coffeePanel, "Mocha", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\mocha.jpeg", 4.75);
        addCoffeeItem(coffeePanel, "Cold Brew", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\cold brew.jpeg", 4.00);
        addCoffeeItem(coffeePanel, "Iced Coffee", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\iced.jpeg", 3.50);
        addCoffeeItem(coffeePanel, "Espresso & Coffee", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\espresso and cofe.jpeg", 4.25);
        addCoffeeItem(coffeePanel, "Breve", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\breve.jpeg", 5.50);

        JScrollPane scrollPane = new JScrollPane(coffeePanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the scroll panel
        add(scrollPane, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        backButton.setFont(new Font("Serif", Font.PLAIN, 19)); // Italic style
        backButton.setBackground(new Color(139, 69, 19));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        add(backButton, BorderLayout.SOUTH);
    }

    private void addCoffeeItem(JPanel panel, String name, String imagePath, double price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BorderLayout());
        itemPanel.setPreferredSize(new Dimension(350, 400)); // Adjusted dimensions for better proportions
        itemPanel.setBackground(new Color(255, 244, 230)); // Light cream background
        itemPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 2)); // Brown border
        itemPanel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor effect for the entire panel

        // Add hover effect
        itemPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                itemPanel.setBackground(new Color(245, 222, 179)); // Lighter cream on hover
                itemPanel.setBorder(BorderFactory.createLineBorder(new Color(160, 82, 45), 3)); // Darker border on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                itemPanel.setBackground(new Color(255, 244, 230)); // Reset to original background
                itemPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 2)); // Reset to original border
            }
        });

        // Coffee Image
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(resizeImageIcon(imagePath, 450, 400)); // Resize image to fit
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(imageLabel, BorderLayout.CENTER);

        // Coffee Name and Price
        String styledText = String.format(
                "<html><span style='color:rgb(51,25,0);font-family:Serif;font-style:italic;font-weight:bold;'>%s</span> - <span style='color:rgb(34,139,34);font-weight:bold;'>$%.2f</span></html>",
                name, price
        );
        JLabel nameLabel = new JLabel(styledText, JLabel.CENTER);
        nameLabel.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 19)); // Italic and bold font for coffee name
        nameLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(160, 82, 45))); // Bottom border under the title
        itemPanel.add(nameLabel, BorderLayout.NORTH);

        // Add to Orders Button
        JButton addButton = new JButton("Add to Orders");
        addButton.setFont(new Font("Serif", Font.ITALIC, 17)); // Italic button text
        addButton.setBackground(new Color(139, 69, 19)); // Coffee-brown
        addButton.setForeground(Color.WHITE);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> {
            OrderManager.addOrderItem(new OrderItem(name, price));
            ManageOrdersPanel.updateOrders();
            JOptionPane.showMessageDialog(this, name + " added to orders!");
        });
        itemPanel.add(addButton, BorderLayout.SOUTH);

        panel.add(itemPanel);
    }

    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
