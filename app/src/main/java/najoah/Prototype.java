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


        //Add rest of prototype here

    

        pikachu = new ImageIcon("pikachu.png");
        //bluePokemon = new ImageIcon("bluePokemon.png");

        pikachuLabel = new JLabel(pikachu);
        //JLabel bluePokemonLabel = new JLabel(bluePokemon);

        mainPanel.add(pikachuLabel);

        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }
}