import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DessertsMenuPanel extends BackgroundPanel {
    public DessertsMenuPanel() {
        super("path/to/desserts-background.jpg"); // Set your background image path
        setLayout(new BorderLayout());

        // Header with Italics and Padding
        JLabel header = new JLabel("Desserts Menu", JLabel.CENTER);
        header.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30)); // Italic and bold font style
        header.setForeground(new Color(102, 51, 0));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add padding around the header
        add(header, BorderLayout.NORTH);

        JPanel dessertsPanel = new JPanel(new GridLayout(0, 3, 20, 20)); // 3 columns with spacing
        dessertsPanel.setOpaque(false);

        // Add dessert items with hover effects
        addMenuItem(dessertsPanel, "Chocolate Cake", "path/to/chocolate_cake.jpg", 5.00);
        addMenuItem(dessertsPanel, "Cheesecake", "path/to/cheesecake.jpg", 4.50);
        addMenuItem(dessertsPanel, "Ice Cream", "path/to/ice_cream.jpg", 3.00);
        addMenuItem(dessertsPanel, "Brownie", "path/to/brownie.jpg", 5.50);
        addMenuItem(dessertsPanel, "Cupcake", "path/to/cupcake.jpg", 4.00);
        addMenuItem(dessertsPanel, "Macarons", "path/to/macarons.jpg", 3.75);

        JScrollPane scrollPane = new JScrollPane(dessertsPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        add(scrollPane, BorderLayout.CENTER);

        // Back Button with Italics
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Serif", Font.PLAIN, 19)); // Italic style
        backButton.setBackground(new Color(139, 69, 19));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("ViewMenu"));
        add(backButton, BorderLayout.SOUTH);
    }

    private void addMenuItem(JPanel panel, String name, String imagePath, double price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BorderLayout());
        itemPanel.setPreferredSize(new Dimension(330, 330)); // Slightly squared
        itemPanel.setBackground(new Color(255, 248, 220)); // Soft beige background
        itemPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 2)); // Brown border
        itemPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        itemPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                itemPanel.setBackground(new Color(245, 222, 179)); // Lighter beige on hover
                itemPanel.setBorder(BorderFactory.createLineBorder(new Color(160, 82, 45), 3)); // Darker brown border
            }

            @Override
            public void mouseExited(MouseEvent e) {
                itemPanel.setBackground(new Color(255, 248, 220)); // Reset to original background
                itemPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 2)); // Reset to original border
            }
        });

        // Dessert Image
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(resizeImageIcon(imagePath, 450, 400));
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


        // Add to Orders Button with Italics
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
