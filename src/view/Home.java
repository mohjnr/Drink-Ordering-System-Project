package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Guest;

public class Home extends JFrame{

    private JTabbedPane tab; 
    //private CardLayout card;
    //private Container c;
    public Home() {

        super("Drink Ordering System");
        this.initComps();
        //this.setLayout();
        this.addComps();
        //this.registerListeners();
        this.addToWindow();
        this.setWindowProperties();
    }

    public void initComps(){
        
        tab = new JTabbedPane();
        //card = new CardLayout(40, 30);
        //c = getContentPane();
    }

    public void addComps(){

        tab.addTab("Guests", new Guest());
        tab.addTab("Employee", new Employee());
    }

    public void addToWindow(){

        this.add(tab);
    }

    public void setWindowProperties(){

        this.setSize(400, 300);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}