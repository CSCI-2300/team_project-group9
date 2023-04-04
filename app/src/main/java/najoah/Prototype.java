package najoah;

import java.awt.*;
import javax.swing.*;

public class Prototype
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private ImageIcon pikachu;
    //private ImageIcon bluePokemon;
    JLabel pikachuLabel;

    public Prototype()
    {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(400, 400));
        mainPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(400,75));

        JButton basic = new JButton("Basic Attack");
        JButton special = new JButton("Special Attack");
        JButton block = new JButton("Block");

        //Add rest of prototype here
        
       

        //pikachu = new ImageIcon("pikachu.png");
        //bluePokemon = new ImageIcon("bluePokemon.png");

        //pikachuLabel = new JLabel(pikachu);
        //JLabel bluePokemonLabel = new JLabel(bluePokemon);

       // mainPanel.add(pikachuLabel);

        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }
}