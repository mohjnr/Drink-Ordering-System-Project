package view;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class OrderInfo extends JPanel {

    private JTextArea receiptArea;
    private JLabel totalLabel;
    private JButton confirmButton;
    private JButton backButton;

    private Map<String, Double> drinkPrices;
    private CardLayout cardLayout;
    private JPanel parentPanel;

    // Default constructor
    public OrderInfo() {
        this.drinkPrices = initializeDefaultDrinkPrices();
        this.cardLayout = null;
        this.parentPanel = null;
        initComps();
        loadOrderInfo(); // Ensure the file is read when the panel is created
    }

    // Parameterized constructor for integration
    public OrderInfo(Map<String, Double> drinkPrices, CardLayout cardLayout, JPanel parentPanel) {
        this.drinkPrices = drinkPrices;
        this.cardLayout = cardLayout;
        this.parentPanel = parentPanel;
        initComps();
        loadOrderInfo(); // Ensure the file is read when the panel is created
    }

    private void initComps() {
        setLayout(new BorderLayout());

        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptArea);

        totalLabel = new JLabel();

        confirmButton = new JButton("Confirm");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);
        buttonPanel.add(backButton);

        confirmButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Your order was submitted to the bartender.", "Order Confirmed", JOptionPane.INFORMATION_MESSAGE);
        });

        backButton.addActionListener(e -> {
            if (cardLayout != null && parentPanel != null) {
                cardLayout.show(parentPanel, "blank");
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(totalLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void loadOrderInfo() {
        receiptArea.setText(""); // Clear existing text
        int totalItems = 0;
        double totalCost = 0.0;

        File file = new File("Drinks.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    double price = drinkPrices.getOrDefault(line, 0.0);
                    receiptArea.append(line + " - $" + String.format("%.2f", price) + "\n");
                    totalItems++;
                    totalCost += price;
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            receiptArea.setText("No orders found. The order file is empty or missing.");
        }

        totalLabel.setText("Total Items: " + totalItems + " | Total Cost: $" + String.format("%.2f", totalCost));
    }

    private Map<String, Double> initializeDefaultDrinkPrices() {
        Map<String, Double> prices = new HashMap<>();
        // Default drink prices
        prices.put("Mojito", 8.50);
        prices.put("Margarita", 9.00);
        prices.put("Old Fashioned", 10.00);
        prices.put("Martini", 11.00);
        prices.put("Whiskey Sour", 9.50);
        prices.put("Pina Colada", 8.00);
        prices.put("Negroni", 10.50);
        prices.put("Cosmopolitan", 9.00);
        prices.put("Sangria", 7.50);
        prices.put("Virgin Mojito", 5.50);
        prices.put("Iced Chai Latte", 4.50);
        prices.put("Lemonade", 3.50);
        prices.put("Fruit Punch", 4.00);
        prices.put("Arnold Palmer", 3.50);
        prices.put("Sparkling Water", 2.50);
        prices.put("Coconut Water", 3.00);
        prices.put("Hibiscus Iced Tea", 4.00);
        prices.put("Mango Lassi", 5.00);

        return prices;
    }
}
