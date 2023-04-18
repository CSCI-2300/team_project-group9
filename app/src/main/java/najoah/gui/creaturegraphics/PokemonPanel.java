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
    

    public PokemonPanel()
    {
        pkmonLabel = new JLabel();


        InputStream input = getClass().getClassLoader().getResourceAsStream("Gradle Bug.png");
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
}