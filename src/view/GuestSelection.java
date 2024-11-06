package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestSelection extends JPanel implements ActionListener {

    private JButton orderButton;
    private JLabel welcome;
    private JButton orderSummary;
    private ImageIcon image;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public GuestSelection() {
        this.initComps();
        this.registerListeners();
    }

    public void initComps() {
        // Initialize CardLayout and mainPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Main panel layout
        JPanel loginPanel = new JPanel(new BorderLayout());

        // Welcome label at the top (centered and bold)
        welcome = new JLabel("Welcome Guest", SwingConstants.CENTER);
        welcome.setFont(new Font("Serif", Font.BOLD, 18));  // Set font to bold and larger size
        loginPanel.add(welcome, BorderLayout.NORTH);

        // Left panel for buttons (Order and Order Summary)
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        orderButton = new JButton("Order");
        orderSummary = new JButton("Order Summary");

        // Set a smaller preferred size for the buttons
        Dimension buttonSize = new Dimension(80, 30);  // Width = 80, Height = 30
        orderButton.setPreferredSize(buttonSize);
        orderSummary.setPreferredSize(buttonSize);

        // Optionally, set a smaller font size if you want even smaller buttons
        Font buttonFont = new Font("Arial", Font.PLAIN, 12);
        orderButton.setFont(buttonFont);
        orderSummary.setFont(buttonFont);

        buttonPanel.add(orderButton);
        buttonPanel.add(orderSummary);

        // Right panel for the image
        image = new ImageIcon("C:\\Users\\ruthe\\Documents\\GitHub\\Drink-Ordering-System-Project\\src\\view\\palm-trees.jpg");
        JLabel imageLabel = new JLabel(image);

        // Add button panel to the left and image to the right in loginPanel
        loginPanel.add(buttonPanel, BorderLayout.WEST);
        loginPanel.add(imageLabel, BorderLayout.EAST);

        // Second panel for CardLayout message
        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel.add(new JLabel("This is Card"));

        // Add both panels to the CardLayout
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(messagePanel, "MessagePanel");

        // Set main layout and add mainPanel to GuestSelection panel
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
    }

    public void registerListeners() {
        orderButton.addActionListener(this);
        orderSummary.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderButton) {
            // Switch to the "MessagePanel" in the mainPanel's CardLayout
            cardLayout.show(mainPanel, "MessagePanel");
        }
    }
}

