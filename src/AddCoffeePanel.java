import javax.swing.*;
import java.awt.*;

class AddCoffeePanel extends BackgroundPanel {
    public AddCoffeePanel() {
        super("path/to/your/coffee-beans-background.jpg"); // Set your background image path
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Select Your Coffee");
        header.setFont(new Font("Serif", Font.BOLD, 30));
        header.setForeground(new Color(102, 51, 0));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header, BorderLayout.NORTH);

        // Coffee Variants
        JPanel coffeePanel = new JPanel(new GridLayout(0, 3, 20, 20)); // 3 columns, spacing between items
        coffeePanel.setOpaque(false);

        // Add coffee items
        addCoffeeItem(coffeePanel, "Espresso", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\espresso.jpeg", 3.00);
        addCoffeeItem(coffeePanel, "Espresso & Coffee", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\espresso and cofe.jpeg", 4.00);
        addCoffeeItem(coffeePanel, "Cold Brew", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\cold brew.jpeg", 4.50);
        addCoffeeItem(coffeePanel, "Cappuccino", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\capucino.jpeg", 4.50);
        addCoffeeItem(coffeePanel, "Mocha", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\mocha.jpeg", 5.00);
        addCoffeeItem(coffeePanel, "Iced Coffee", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\iced.jpeg", 3.50);
        addCoffeeItem(coffeePanel, "Latte", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\lattes.jpeg", 4.75);
        addCoffeeItem(coffeePanel, "Breve", "C:\\Users\\hp\\Desktop\\cofee\\cofefefefe\\src\\resources\\breve.jpeg", 5.50);

        JScrollPane scrollPane = new JScrollPane(coffeePanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.setBackground(new Color(139, 69, 19));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        add(backButton, BorderLayout.SOUTH);
    }

    private void addCoffeeItem(JPanel panel, String name, String imagePath, double price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BorderLayout());
        itemPanel.setPreferredSize(new Dimension(350, 350));
        itemPanel.setBackground(new Color(255, 244, 230)); // Light cream background
        itemPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 2)); // Brown border

        // Coffee Image
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(resizeImageIcon(imagePath, 300, 250)); // Resize image to fit
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(imageLabel, BorderLayout.CENTER);

        // Coffee Name and Price
        JLabel nameLabel = new JLabel(name + " - $" + price);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setForeground(new Color(51, 25, 0));
        itemPanel.add(nameLabel, BorderLayout.NORTH);

        // Add to Orders Button
        JButton addButton = new JButton("Add to Orders");
        addButton.setFont(new Font("Arial", Font.PLAIN, 14));
        addButton.setBackground(new Color(139, 69, 19)); // Coffee-brown
        addButton.setForeground(Color.WHITE);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> {
            OrderManager.addOrderItem(new OrderItem(name, price));
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
