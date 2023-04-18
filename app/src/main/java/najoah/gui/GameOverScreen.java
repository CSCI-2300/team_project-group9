package najoah.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Will create a game over panel, if true is inputted into the constructor a player win label will display,
* if false is inputted a player loss label will display
*/

public class GameOverScreen extends JPanel
{
    private Boolean status;
    private JLabel playerWinLabel;
    private JLabel playerLossLabel;
    private JButton playAgainButton;

    public GameOverScreen(Boolean status)
    {
        this.status = status;

        this.playerWinLabel = new JLabel("Congratulations! You have won!");
        this.playerWinLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.playerLossLabel = new JLabel("Sorry! You have lost.");
        this.playerLossLabel.setFont(new Font("Verdana", Font.PLAIN, 30));

        this.playAgainButton = new JButton("Play Again");
        this.playAgainButton.setPreferredSize(new Dimension(150,75));

        if (status)
        {
            this.add(playerWinLabel);
        }
        else
        {
            this.add(playerLossLabel);
        }

        this.add(playAgainButton);
    }
}