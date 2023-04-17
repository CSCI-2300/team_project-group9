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

public class HealthBarPanel extends JPanel
{   
    private int currentHP;
    private int maxHP = 50;
    private JLabel textBar;
    private JPanel visualBar;
    private JLabel owner;
    private BufferedImage pkmonImage;
    private JLabel pkmonLabel;

    public HealthBarPanel(String owner,int currentHP)
    {
        this.currentHP = currentHP;
        this.owner = new JLabel(owner);
        
        textBar = new JLabel(currentHP+"/"+maxHP);
        visualBar = new JPanel();
        pkmonLabel = new JLabel();
        InputStream input = getClass().getClassLoader().getResourceAsStream("Gradle Bug.png");
        try
        {
            pkmonImage = ImageIO.read(input);
            pkmonLabel.setIcon(new ImageIcon(new ImageIcon(pkmonImage).getImage().getScaledInstance(128,128, Image.SCALE_DEFAULT)));
        }
        catch(Exception e){}

        visualBar.setBackground(Color.RED);
        visualBar.setPreferredSize(new Dimension(50,15));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
       

        this.add(this.owner);
        this.add(textBar);
        this.add(visualBar);
        this.add(pkmonLabel);

        
    }

    public void changeHealth(int currentHP)
    {   
        if(currentHP >= 0)
            this.currentHP = currentHP;
        else
            this.currentHP = 0;
        textBar.setText(this.currentHP+"/"+this.maxHP);
    }

    public void lowerHealthBar()
    {
        visualBar.setPreferredSize(new Dimension(this.currentHP,15));
    }
}