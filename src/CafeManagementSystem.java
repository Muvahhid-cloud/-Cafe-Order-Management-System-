import javax.swing.*;
import java.awt.*;

public class CafeManagementSystem {
    private static CardLayout cardLayout = new CardLayout(); // For switching panels
    private static JPanel mainPanel = new JPanel(cardLayout); // Holds all panels

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cafe Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        // Add all panels to the main panel
        mainPanel.add(new MainMenuPanel(), "MainMenu");
        mainPanel.add(new AddCoffeePanel(), "AddCoffee");
        mainPanel.add(new ViewMenuPanel(), "ViewMenu");
        mainPanel.add(new ManageOrdersPanel(), "ManageOrders");
        mainPanel.add(new DessertsMenuPanel(), "DessertsMenu");
        mainPanel.add(new DrinksMenuPanel(), "DrinksMenu");
        mainPanel.add(new DonersMenuPanel(), "DonersMenu");


        // Set the main panel as the content pane
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    // Method to switch panels
    public static void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
}
//Это ошибка зайниддин