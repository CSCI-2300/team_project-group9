
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

    private JLabel textHP;
    private JLabel owner;

    public HealthBar(String owner,int HP)
    {
        this.setLayout(null);

        //creating text for labels
        this.owner = new JLabel(owner);
        this.textHP = new JLabel(""+HP+"/"+HP);
        this.owner.setBounds(20,-3,70,30);
        this.textHP.setBounds(22,20,60,10);

        pane = new JLayeredPane();


        //making labels to prevent crash
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
       //adding health gui
        pane.setBounds(0,0,128,180);
        pane.add(healthBarTotalLabel,1);
        pane.add(healthBarGreenLabel,0);

        //adding health and name labels
        pane.add(this.textHP,0);
        pane.add(this.owner,0);

        this.add(pane);
        this.setOpaque(false);
    }

    public void setHP(int health)
    {
       // healthBarTotalLabel.setBounds(xOfTotal,yOfTotal,/*THIS IS WHAT U REDUCE TO DECREASE BAR*/,48);
        //yet to be implemented, adjust length and bounds of greenlabel
    }

}
