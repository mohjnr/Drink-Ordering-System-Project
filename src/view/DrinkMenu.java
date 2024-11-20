package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DrinkMenu extends JPanel {

    private JButton alcoholic;
    private JButton nonAlcoholic;

    private JButton mojito;
    private JButton margarita;
    private JButton oldFashioned;
    private JButton martini;
    private JButton whiskeySour;
    private JButton pinaColada;
    private JButton negroni;
    private JButton cosmopolitan;
    private JButton sangria;

    private JButton virginMojito;
    private JButton icedChaiLatte;
    private JButton lemonade;
    private JButton fruitPunch;
    private JButton arnoldPalmer;
    private JButton sparklingWater;
    private JButton coconutWater;
    private JButton hibiscusIcedTea;
    private JButton mangoLassi;

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel alDrinksMenu;
    private JPanel nalDrinksMenu;

    public DrinkMenu() {
        this.initComps();
        this.registerListeners();
    }

    public void initComps() {

        // Initialize CardLayout and mainPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Buttons for side menu
        alcoholic = new JButton("Alcoholic");
        nonAlcoholic = new JButton("Non-Alcoholic");

        // Side menu with Alcoholic and Non-Alcoholic buttons
        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));
        sideMenu.add(alcoholic);
        sideMenu.add(nonAlcoholic);

        // Initialize alcoholic drink buttons
        mojito = new JButton("Mojito");
        margarita = new JButton("Margarita");
        oldFashioned = new JButton("Old Fashioned");
        martini = new JButton("Martini");
        whiskeySour = new JButton("Whiskey Sour");
        pinaColada = new JButton("Pina Colada");
        negroni = new JButton("Negroni");
        cosmopolitan = new JButton("Cosmopolitan");
        sangria = new JButton("Sangria");

        // Initialize non-alcoholic drink buttons
        virginMojito = new JButton("Virgin Mojito");
        icedChaiLatte = new JButton("Iced Chai Latte");
        lemonade = new JButton("Lemonade");
        fruitPunch = new JButton("Fruit Punch");
        arnoldPalmer = new JButton("Arnold Palmer");
        sparklingWater = new JButton("Sparkling Water");
        coconutWater = new JButton("Coconut Water");
        hibiscusIcedTea = new JButton("Hibiscus Iced Tea");
        mangoLassi = new JButton("Mango Lassi");

        // Panels for drink menus
        alDrinksMenu = new JPanel(new GridLayout(3, 3));
        nalDrinksMenu = new JPanel(new GridLayout(3, 3));

        // Add alcoholic drink buttons to alDrinksMenu
        alDrinksMenu.add(mojito);
        alDrinksMenu.add(margarita);
        alDrinksMenu.add(oldFashioned);
        alDrinksMenu.add(martini);
        alDrinksMenu.add(whiskeySour);
        alDrinksMenu.add(pinaColada);
        alDrinksMenu.add(negroni);
        alDrinksMenu.add(cosmopolitan);
        alDrinksMenu.add(sangria);

        // Add non-alcoholic drink buttons to nalDrinksMenu
        nalDrinksMenu.add(virginMojito);
        nalDrinksMenu.add(icedChaiLatte);
        nalDrinksMenu.add(lemonade);
        nalDrinksMenu.add(fruitPunch);
        nalDrinksMenu.add(arnoldPalmer);
        nalDrinksMenu.add(sparklingWater);
        nalDrinksMenu.add(coconutWater);
        nalDrinksMenu.add(hibiscusIcedTea);
        nalDrinksMenu.add(mangoLassi);

        // Add the drink panels to the mainPanel (CardLayout)
        mainPanel.add(new JPanel(), "blank"); // Blank panel as default
        mainPanel.add(alDrinksMenu, "alcoholic");
        mainPanel.add(nalDrinksMenu, "nonAlcoholic");

        // Layout for main DrinkMenu panel
        setLayout(new BorderLayout());
        add(sideMenu, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Show blank panel initially
        cardLayout.show(mainPanel, "blank");
    }

    public void registerListeners() {
        alcoholic.addActionListener(e -> cardLayout.show(mainPanel, "alcoholic"));
        nonAlcoholic.addActionListener(e -> cardLayout.show(mainPanel, "nonAlcoholic"));

        // Add action listeners for all drink buttons
        ActionListener drinkButtonListener = e -> {
            String drinkName = ((JButton) e.getSource()).getText();
            addDrinkToFile(drinkName);
            JOptionPane.showMessageDialog(this, drinkName + " has been added to your order.", "Drink Added", JOptionPane.INFORMATION_MESSAGE);
        };

        for (Component c : alDrinksMenu.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(drinkButtonListener);
            }
        }

        for (Component c : nalDrinksMenu.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(drinkButtonListener);
            }
        }
    }

    private void addDrinkToFile(String drinkName) {
        File file = new File("Drinks.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(drinkName);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}