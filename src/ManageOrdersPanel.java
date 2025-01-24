import javax.swing.*;
import java.awt.*;

class ManageOrdersPanel extends JPanel {
    public ManageOrdersPanel() {
        setLayout(new GridBagLayout());

        JLabel header = new JLabel("Manage Orders");
        header.setFont(new Font("Arial", Font.BOLD, 24));
        add(header, getConstraints(0, 0, 1, 1, 10));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        add(backButton, getConstraints(0, 1, 1, 1, 10));
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
