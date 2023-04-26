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

public class EnergyBar extends JPanel
{
    private JLayeredPane pane;
    private BufferedImage energyBarBlue;
    private BufferedImage energyBarTotal;
    private JLabel energyBarBlueLabel;
    private JLabel energyBarTotalLabel;
    private int xOfTotal = 0;
    private int yOfTotal = 0;

    private JLabel textEnergy;
    private JLabel owner;


    public EnergyBar(int energy)
    {
        this.setLayout(null);

        //creating text for labels
        this.textEnergy = new JLabel(""+energy+"/"+energy);

        this.textEnergy.setBounds(60,10,60,10);
        pane = new JLayeredPane();


        //making labels to prevent crash
        energyBarBlueLabel = new JLabel();
        energyBarTotalLabel = new JLabel();

        //importing the total bar
        InputStream input = getClass().getClassLoader().getResourceAsStream("EnergyBar.png");
        try
        {
            energyBarTotal = ImageIO.read(input);
            energyBarTotalLabel.setIcon(new ImageIcon(new ImageIcon(energyBarTotal).getImage().getScaledInstance(128,48, Image.SCALE_DEFAULT)));
            energyBarTotalLabel.setBounds(xOfTotal,yOfTotal,128,48);
        }
        catch(Exception e){}

        //importing the blue bar
        input = getClass().getClassLoader().getResourceAsStream("Energy.png");
        try
        {
            energyBarBlue = ImageIO.read(input);
            energyBarBlueLabel.setIcon(new ImageIcon(new ImageIcon(energyBarBlue).getImage().getScaledInstance(128,48, Image.SCALE_DEFAULT)));
            energyBarBlueLabel.setBounds(xOfTotal,(yOfTotal),128,48);
        }
        catch(Exception e){}

        /* 
        now they shall both be added to a layered pane,
        the green bar will be fit to the position of the total bar
        and there will be a method to shrink the green bar to fit with a ratio of the health of the pokemon
        */
       //adding energy gui
        pane.setBounds(0,0,129,50);
        pane.add(energyBarTotalLabel,1);
        pane.add(energyBarBlueLabel,0);

        pane.add(this.textEnergy,0);

        this.add(pane);
        this.setOpaque(false);
    }

    public void setEnergy(int currentEnergy,int maxEnergy)
    {
        float max = maxEnergy;
        float current = currentEnergy;

        energyBarBlueLabel.setBounds(xOfTotal,yOfTotal,Math.round(121.0f*(current/max)+7),48);
        textEnergy.setText(currentEnergy+"/"+maxEnergy);
    }

}
