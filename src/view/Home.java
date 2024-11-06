package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Guest;

public class Home{

    private JFrame guests;
    private JFrame employees;

    public Home(){
        this.initComps();
        //this.setLayout();
        //this.addComps();
        //this.registerListeners();
        this.addToWindow();
        this.setWindowProperties();
    }

    public void initComps(){

        this.guests = new JFrame("Guests menu");
        this.employees =  new JFrame("Employee menu");
    }

    public void addToWindow(){
        
        guests.add(new Guest());
        employees.add(new Employee());
    }

    public void setWindowProperties(){
        guests.setSize(400, 300);
        guests.setResizable(false);
        guests.setVisible(true);
        guests.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        employees.setSize(400, 300);
        employees.setResizable(false);
        employees.setVisible(true);
        employees.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}