package najoah.gui;

import najoah.gui.creaturegraphics.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/*we should make this specifically a healthbar class, with name
we should then have a sperate class for the pokemon to be loaded,
then throw all of it into one panel
*/

public class HealthBarPanel extends JPanel
{   

    private HealthBar healthBar;
    private PokemonPanel pkmon;

    public HealthBarPanel(String owner,int MaxHP)
    {
        pkmon = new PokemonPanel();
        healthBar = new HealthBar(owner,MaxHP);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(180,256));

        pkmon.setBounds(0,48,128,128);
        healthBar.setBounds(0,0,128,48);

        this.add(healthBar);
        this.add(pkmon);

        this.setOpaque(false);
        
    }

    public void setHP(int currentHP,int MaxHP)
    {   
        if(currentHP >= 0)
            healthBar.setHP(currentHP,MaxHP);
        else
            healthBar.setHP(0,MaxHP);
    }

}