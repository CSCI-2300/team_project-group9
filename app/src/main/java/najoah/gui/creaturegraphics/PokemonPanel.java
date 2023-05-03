package najoah.gui.creaturegraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class PokemonPanel extends JPanel
{   
    private BufferedImage pkmonImage;
    private JLabel pkmonLabel;
    private InputStream input;

    public PokemonPanel()
    {
        pkmonLabel = new JLabel();


        input = getClass().getClassLoader().getResourceAsStream("Gradle Bug.png");
        try
        {
            pkmonImage = ImageIO.read(input);
            pkmonLabel.setIcon(new ImageIcon(new ImageIcon(pkmonImage).getImage().getScaledInstance(128,128, Image.SCALE_DEFAULT)));
            pkmonLabel.setBounds(0,0,128,128);
        }
        catch(Exception e){}

        this.setOpaque(false);
        this.add(pkmonLabel);

    }
    public void setType(int type)
    {
        switch(type){
            case 0:
                input = getClass().getClassLoader().getResourceAsStream("creepy.png");
                break;
            case 1:
                input = getClass().getClassLoader().getResourceAsStream("Gradle Bug.png");
                break;
            case 2:
                input = getClass().getClassLoader().getResourceAsStream("sassquatch.PNG");
                break;
            case 3:
                input = getClass().getClassLoader().getResourceAsStream("Spider.png");
                break;
            case 4:
                input = getClass().getClassLoader().getResourceAsStream("IceGiant.png");
                break;
            
            case 5:
                input = getClass().getClassLoader().getResourceAsStream("coffend.png");
                break;
        }
        try
        {
            pkmonImage = ImageIO.read(input);
            pkmonLabel.setIcon(new ImageIcon(new ImageIcon(pkmonImage).getImage().getScaledInstance(128,128, Image.SCALE_DEFAULT)));
            pkmonLabel.setBounds(0,0,128,128);
        }
        catch(Exception e){}

    }
}