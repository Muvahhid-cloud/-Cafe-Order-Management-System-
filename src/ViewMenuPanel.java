import javax.swing.*;
import java.awt.*;

class ViewMenuPanel extends JPanel {
    public ViewMenuPanel() {
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Coffee Menu", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        add(header, BorderLayout.NORTH);

        JTextArea menuArea = new JTextArea("1. Espresso\n2. Latte\n3. Cappuccino\n4. Mocha");
        menuArea.setEditable(false);
        menuArea.setFont(new Font("Arial", Font.PLAIN, 18));
        add(new JScrollPane(menuArea), BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> CafeManagementSystem.switchPanel("MainMenu"));
        add(backButton, BorderLayout.SOUTH);
    }
}
