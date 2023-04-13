package najoah;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Prototype
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private ImageIcon pikachu;
    //private ImageIcon bluePokemon;
    //JLabel pikachuLabel;
    

    public Prototype()
    {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(400, 400));
        mainPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,150,50));
        

        topPanel.setPreferredSize(new Dimension(400,100));
        bottomPanel.setPreferredSize(new Dimension(400,75));

        JButton basic = new JButton("Basic Attack");
        JButton special = new JButton("Special Attack");
        JButton block = new JButton("Block");

        HealthBarPanel playerHP = new HealthBarPanel("Player", 37);
        HealthBarPanel enemyHP = new HealthBarPanel("Enemy", 50);

        topPanel.add(playerHP);
        topPanel.add(enemyHP);

        bottomPanel.add(basic);
        bottomPanel.add(special);
        bottomPanel.add(block);
        //Add rest of prototype here
        
       

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
}