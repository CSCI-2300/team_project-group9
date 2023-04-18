
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
    private int xOfTotal = 0;
    private int yOfTotal = 0;

    private JLabel textBar;

    public HealthBar()
    {
        this.setLayout(null);
        pane = new JLayeredPane();
        healthBarGreenLabel = new JLabel();
        healthBarTotalLabel = new JLabel();

        //importing the total bar
        InputStream input = getClass().getClassLoader().getResourceAsStream("PokemonBar.png");
        try
        {
            healthBarTotal = ImageIO.read(input);
            healthBarTotalLabel.setIcon(new ImageIcon(new ImageIcon(healthBarTotal).getImage().getScaledInstance(128,48, Image.SCALE_DEFAULT)));
            healthBarTotalLabel.setBounds(xOfTotal,yOfTotal,128,48);
        }
        catch(Exception e){}

        //importing the green bar
        input = getClass().getClassLoader().getResourceAsStream("GreenHealth.png");
        try
        {
            healthBarGreen = ImageIO.read(input);
            healthBarGreenLabel.setIcon(new ImageIcon(new ImageIcon(healthBarGreen).getImage().getScaledInstance(128,48, Image.SCALE_DEFAULT)));
            healthBarGreenLabel.setBounds(xOfTotal-7,(yOfTotal+4),128,48);
        }
        catch(Exception e){}


        //creating health to store on the bar and edit
        //textBar = new JLabel("50/50");
       // textBar.setBounds(xOfTotal+30,yOfTotal-30,50,50);

        /* 
        now they shall both be added to a layered pane,
        the green bar will be fit to the position of the total bar
        and there will be a method to shrink the green bar to fit with a ratio of the health of the pokemon
        */
        pane.setBounds(0,0,128,180);
        pane.add(healthBarTotalLabel,1);
        pane.add(healthBarGreenLabel,0);
        //pane.add(textBar,0);

        this.add(pane);
        this.setOpaque(false);
    }

    public void changeHealth(int health)
    {
       // healthBarTotalLabel.setBounds(xOfTotal,yOfTotal,/*THIS IS WHAT U REDUCE TO DECREASE BAR*/,48);
        //yet to be implemented, adjust length and bounds of greenlabel
    }

}
