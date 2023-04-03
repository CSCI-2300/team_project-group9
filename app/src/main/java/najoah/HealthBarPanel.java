package najoah;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HealthBarPanel extends JPanel
{   
    private int currentHP = 37;
    private int maxHP = 50;
    private JLabel textBar;
    private JPanel visualBar;
    private JLabel owner;

    public HealthBarPanel(String owner)
    {
        this.owner = new JLabel(owner);
        textBar = new JLabel(currentHP+"/"+maxHP);
        visualBar = new JPanel();
        
        visualBar.setBackground(Color.RED);
        visualBar.setPreferredSize(new Dimension(40,15));

        this.setPreferredSize(new Dimension(80,40));

        this.add(this.owner);
        this.add(textBar);
        this.add(visualBar);
        
    }


}