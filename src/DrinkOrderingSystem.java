import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinkOrderingSystem extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    public DrinkOrderingSystem() {
        setTitle("Drink Ordering System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Use CardLayout for switching between login, menu, and management views
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        // Adding the panels for the various sections
        cardPanel.add(createLoginPanel(), "LoginPanel");
        cardPanel.add(createMenuPanel(), "MenuPanel");
        cardPanel.add(createManagerPanel(), "ManagerPanel");
        
        add(cardPanel);
        cardLayout.show(cardPanel, "LoginPanel");
    }
    
    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));
        
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simple login logic, shows the menu for simplicity
                cardLayout.show(cardPanel, "MenuPanel");
            }
        });
        
        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(new JLabel()); // empty space
        loginPanel.add(loginButton);
        
        return loginPanel;
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1, 10, 10));
        
        JComboBox<String> drinkType = new JComboBox<>(new String[]{"Alcoholic", "Non-Alcoholic"});
        JButton orderButton = new JButton("Order Drink");
        JButton statusButton = new JButton("View Order Status");

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Drink Ordered: " + drinkType.getSelectedItem());
            }
        });

        menuPanel.add(drinkType);
        menuPanel.add(orderButton);
        menuPanel.add(statusButton);
        
        return menuPanel;
    }

    private JPanel createManagerPanel() {
        JPanel managerPanel = new JPanel();
        managerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        
        JButton addDrinkButton = new JButton("Add Drink");
        JButton modifyDrinkButton = new JButton("Modify Drink");
        JButton removeDrinkButton = new JButton("Remove Drink");
        JButton reportButton = new JButton("Generate Report");
        
        addDrinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Add Drink function");
            }
        });

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Report Generated");
            }
        });

        managerPanel.add(addDrinkButton);
        managerPanel.add(modifyDrinkButton);
        managerPanel.add(removeDrinkButton);
        managerPanel.add(reportButton);
        
        return managerPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrinkOrderingSystem().setVisible(true);
            }
        });
    }
}
