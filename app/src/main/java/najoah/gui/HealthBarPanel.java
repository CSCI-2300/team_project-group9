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
    private EnergyBar energyBar;

    public HealthBarPanel(String owner,int MaxHP, int maxEnergy)
    {
        pkmon = new PokemonPanel();
        healthBar = new HealthBar(owner,MaxHP);
        energyBar = new EnergyBar(maxEnergy);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(180,400));

        pkmon.setBounds(0,48,128,128);
        healthBar.setBounds(0,0,128,48);
        energyBar.setBounds(0,176,128,48);

        this.add(healthBar);
        this.add(pkmon);
        this.add(energyBar);

        this.setOpaque(false);
        
    }
    public void setType(int type)
    {
        this.pkmon.setType(type);
        if(type == 3)
            pkmon.setBounds(20,80,128,128);
    }

    public void setHP(int currentHP,int maxHP)
    {   
        if(currentHP >= 0)
            healthBar.setHP(currentHP,maxHP);
        else
            healthBar.setHP(0,maxHP);
    }
    
    public void setEnergy(int currentEnergy, int maxEnergy)
    {
        if(currentEnergy >= 0)
            energyBar.setEnergy(currentEnergy,maxEnergy);
        else
            energyBar.setEnergy(0,maxEnergy);
    }

    public void setOwner(String owner)
    {
        this.healthBar.setOwner(owner);
    }

}