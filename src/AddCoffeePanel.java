import javax.swing.*;
import java.awt.*;

class AddCoffeePanel extends JPanel {
    public AddCoffeePanel() {
        setLayout(new GridBagLayout());

        JLabel header = new JLabel("Add Coffee Item");
        header.setFont(new Font("Arial", Font.BOLD, 24));
        add(header, getConstraints(0, 0, 2, 1, 10));

        JLabel label = new JLabel("Select Coffee Type:");
        JComboBox<String> coffeeTypeCombo = new JComboBox<>(new String[]{"Espresso", "Latte", "Cappuccino", "Mocha"});
        add(label, getConstraints(0, 1, 1, 1, 5));
        add(coffeeTypeCombo, getConstraints(1, 1, 1, 1, 5));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        add(backButton, getConstraints(0, 2, 2, 1, 10));
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
