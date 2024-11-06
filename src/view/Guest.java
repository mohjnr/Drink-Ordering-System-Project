package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guest extends JPanel implements ActionListener{

    private JLabel armband;
    private JTextField armbandCode;
    //private JPanel pan1;
    //private JPanel pan2;
    //private JPanel pan3;
    //private JPanel pan4;
    private JButton login;
    private JButton clear;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public Guest(){
        this.initcomps();
        //this.addToPanel();
        //this.setLayout();
        //this.addComps();
        //this.setWindowProperties();
       this.registerListeners();
    }

    public void initcomps(){

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel loginPanel = new JPanel(new GridLayout(2, 2));

        armband = new JLabel("Armband Code: ");
        armbandCode = new JTextField(20);
        //this.pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //this.pan2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //this.pan3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //this.pan4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.login = new JButton("Login");
        this.clear = new JButton("Clear");

        loginPanel.add(armband);
        loginPanel.add(armbandCode);
        loginPanel.add(login);
        loginPanel.add(clear);

        
        // Second Panel (the "This is Card" message)
        JPanel messagePanel = new GuestSelection();
        //messagePanel.add(new JLabel("This is Card"));

        // Add both panels to the CardLayout
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(messagePanel, "MessagePanel");

        // Add mainPanel to the Employee panel
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
    }

    

    public void registerListeners(){

        login.addActionListener(this);
        clear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource().equals(clear)){
            armbandCode.setText("");
        }
        else{
            // Optionally, open a new frame with the message

            cardLayout.show(mainPanel, "MessagePanel");

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
