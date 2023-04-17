package najoah.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

import najoah.controller.*;
import najoah.model.*;
import najoah.model.pokemon.*;

public class GameGUI implements ActionListener
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel moveLabel;
    private ImageIcon pikachu;
    private Controller controller;
    private Model model;
    private HealthBarPanel playerHP;
    private HealthBarPanel computerHP;

    //private ImageIcon bluePokemon;
    //JLabel pikachuLabel;
    

    public GameGUI(Model model, Controller controller)
    {
        this.controller = controller;
        this.model = model;

        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(500, 400));
        mainPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,150,50));
        topPanel.setPreferredSize(new Dimension(400,100));
        bottomPanel.setPreferredSize(new Dimension(400,75));
        
        //trying to make pokemon appear horizontal to each other healthbar code  bugged
        //topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        this.moveLabel = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.moveLabel.setBorder(border);
        this.moveLabel.setVerticalAlignment(JLabel.BOTTOM);

        JButton basic = new JButton("Basic Attack");
        basic.addActionListener(this);
        JButton special = new JButton("Special Attack");
        special.addActionListener(this);
        JButton block = new JButton("Block");
        block.addActionListener(this);

        this.playerHP = new HealthBarPanel("Player", 50);
        this.computerHP = new HealthBarPanel("Computer", 50);

        topPanel.add(playerHP);
        topPanel.add(computerHP);


        bottomPanel.add(moveLabel);
        bottomPanel.add(basic);
        bottomPanel.add(special);
        bottomPanel.add(block);
        bottomPanel.add(moveLabel);
       

        //pikachu = new ImageIcon("pikachu.png");
        //bluePokemon = new ImageIcon("bluePokemon.png");

        //pikachuLabel = new JLabel(pikachu);
        //JLabel bluePokemonLabel = new JLabel(bluePokemon);

       // mainPanel.add(pikachuLabel);
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }


    //Gets input from user and returns selected move as a string
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        String move = button.getText();

        //tell controller about selected move
        this.controller.playTurn(move);
    }

    public void update()
    {
        Pokemon[] pokes = model.getPokemon();
        this.playerHP.changeHealth(pokes[0].getHealthCurrent());
        this.playerHP.lowerHealthBar();
        this.computerHP.changeHealth(pokes[1].getHealthCurrent());
        this.computerHP.lowerHealthBar();

        this.moveLabel.setText("The user performed a "+pokes[0].getMove().getName()+". The computer perfomed a "+pokes[1].getMove().getName()+".");
    }

}