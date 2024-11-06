package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee extends JPanel implements ActionListener {

    private JLabel id;
    private JTextField idtxt;
    private JLabel password;
    private JTextField passwordtxt;
    private JButton login;
    private JButton clear;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public Employee() {
        this.initComps();
        this.addComps();
        this.registerListeners();
    }

    public void initComps() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // First Panel with Login Fields
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        id = new JLabel("Employee ID: ");
        idtxt = new JTextField(20);
        password = new JLabel("Password");
        passwordtxt = new JTextField(20);
        login = new JButton("Login");
        clear = new JButton("Clear");

        loginPanel.add(id);
        loginPanel.add(idtxt);
        loginPanel.add(password);
        loginPanel.add(passwordtxt);
        loginPanel.add(login);
        loginPanel.add(clear);

        // Second Panel (the "This is Card" message)
        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel.add(new JLabel("This is Card"));

        // Add both panels to the CardLayout
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(messagePanel, "MessagePanel");

        // Add mainPanel to the Employee panel
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
    }

    public void addComps() {
        // Components are already added in initComps
    }

    public void registerListeners() {
        login.addActionListener(this);
        clear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            idtxt.setText("");
            passwordtxt.setText("");
        } else if (e.getSource() == login) {
            // Switch to the "This is Card" message panel
            // Show the "MessagePanel" in the mainPanel's CardLayout
            cardLayout.show(mainPanel, "MessagePanel");

            // Optionally, open a new frame with the message
            JPanel messageFrame = new JPanel();
            //messageFrame.setSize(200, 100);
            messageFrame.add(new JLabel("This is Card", SwingConstants.CENTER));
            //messageFrame.setLocationRelativeTo(this);
            messageFrame.setVisible(true);

            // Close the original frame
            //SwingUtilities.getWindowAncestor(this).dispose();

        }
    }
}

