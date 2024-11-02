package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guest extends JPanel implements ActionListener{

    private JLabel armband;
    private JTextField armbandCode;
    private JPanel pan1;
    private JPanel pan2;
    private JPanel pan3;
    private JPanel pan4;
    private JButton login;
    private JButton clear;

    public Guest(){
        this.initcomps();
        this.addToPanel();
        this.setLayout();
        this.addComps();
        //this.setWindowProperties();
       this.registerListeners();
    }

    public void initcomps(){

        armband = new JLabel("Armband Code: ");
        armbandCode = new JTextField(20);
        this.pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.pan2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.pan3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.pan4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.login = new JButton("Login");
        this.clear = new JButton("Clear");
    }

    public void addToPanel(){

        pan1.add(armband); pan2.add(armbandCode);
        pan3.add(login); pan4.add(clear);

    }

    public void setLayout(){

        this.setLayout(new GridLayout(2,2));
    }

    public void addComps(){

        this.add(pan1); this.add(pan2);
        this.add(pan3); this.add(pan4);
    }

    public void registerListeners(){

        this.login.addActionListener(this);
        this.clear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource().equals(clear)){
            armbandCode.setText("");
        }
        else{
            
        }
    }
    
}
