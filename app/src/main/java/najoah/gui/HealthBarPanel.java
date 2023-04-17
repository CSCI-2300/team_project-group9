package najoah.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HealthBarPanel extends JPanel
{   
    private int currentHP;
    private int maxHP = 50;
    private JLabel textBar;
    private JPanel visualBar;
    private JLabel owner;

    public HealthBarPanel(String owner,int currentHP)
    {
        this.currentHP = currentHP;
        this.owner = new JLabel(owner);
        
        textBar = new JLabel(currentHP+"/"+maxHP);
        visualBar = new JPanel();
        
        visualBar.setBackground(Color.RED);
        visualBar.setPreferredSize(new Dimension(50,15));

        this.setPreferredSize(new Dimension(65,80));

        this.add(this.owner);
        this.add(textBar);
        this.add(visualBar);
        
    }

    public void changeHealth(int currentHP)
    {
        this.currentHP = currentHP;
        textBar.setText(this.currentHP+"/"+this.maxHP);
    }

    public void lowerHealthBar()
    {
        visualBar.setPreferredSize(new Dimension(this.currentHP,15));
    }
}