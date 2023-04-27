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


/** Will create a game over panel, if true is inputted into the constructor a player win label will display,
* if false is inputted a player loss label will display
*/

public class GameOverScreen extends JPanel
{
    private Boolean status;
    private JLabel playerWinLabel;
    private JLabel playerLossLabel;
    private JButton playAgainButton;

    private BufferedImage forestImage;
    private JLabel forestLabel;

    public GameOverScreen(Boolean status,int wins,int losses)
    {
        this.status = status;

        this.playerWinLabel = new JLabel("Congratulations! You have won the match!");
        this.playerWinLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.playerLossLabel = new JLabel("Sorry! You have lost the match."+" You won: "+wins+" battles"+" You Lost: "+losses+" battles");
        this.playerLossLabel.setFont(new Font("Verdana", Font.PLAIN, 30));

        this.playAgainButton = new JButton("Play Again");
        this.playAgainButton.setPreferredSize(new Dimension(150,75));

        forestLabel = new JLabel();
        InputStream input = getClass().getClassLoader().getResourceAsStream("Drawing 3.png");
        try
        {
            forestImage = ImageIO.read(input);
            forestLabel.setIcon(new ImageIcon(new ImageIcon(forestImage).getImage().getScaledInstance(768, 256, Image.SCALE_DEFAULT)));
            forestLabel.setBounds(30,8,769,257);
        }
        catch(Exception e){}

        this.add(forestLabel);

        if (status)
        {
            this.add(playerWinLabel);
        }
        else
        {
            this.add(playerLossLabel);
        }

        //this.add(playAgainButton);
    }
}