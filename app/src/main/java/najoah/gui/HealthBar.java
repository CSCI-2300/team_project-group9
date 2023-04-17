package najoah.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class HealthBar extends JPanel
{
    private JLayeredPane pane;
    private BufferedImage healthBarGreen;
    private BufferedImage healthBarTotal;
    private JLabel healthBarGreenLabel;
    private JLabel healthBarTotalLabel;

    public HealthBar()
    {
        //importing the total bar
        InputStream input = getClass().getClassLoader().getResourceAsStream("PokemonBar.png");
        try
        {
            healthBarTotal = ImageIO.read(input);
            healthBarTotalLabel.setIcon(new ImageIcon(new ImageIcon(HealthBarTotal).getImage().getScaledInstance(128,48, Image.SCALE_DEFAULT)));
        }
        catch(Exception e){}

        //importing the green bar
        InputStream input = getClass().getClassLoader().getResourceAsStream("Gradle Bug.png");
        try
        {
            healthBarGreen = ImageIO.read(input);
            healthBarGreenLabel.setIcon(new ImageIcon(new ImageIcon(healthBarGreen).getImage().getScaledInstance(128,48, Image.SCALE_DEFAULT)));
        }
        catch(Exception e){}

        /* 
        now they shall both be added to a layered pane,
        the green bar will be fit to the position of the total bar
        and there will be a method to shrink the green bar to fit with a ratio of the health of the pokemon
        */


    }


}