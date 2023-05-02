package najoah.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartScreen extends JPanel
{
    private JLabel titleLabel;
    private JButton newGameButton;
    private JButton continueButton;
    private JButton helpButton;
    private JLabel helpBox;
    private BoxLayout boxLayout;

    public StartScreen(ActionListener listener) 
    {
        GridLayout buttonLayout = new GridLayout(0,1);
        this.setLayout(buttonLayout);

        titleLabel = new JLabel("NaJoAh");
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel sizePanel1 = new JPanel();
        newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(new Dimension(150,75));
        sizePanel1.add(newGameButton);
        newGameButton.addActionListener(listener);

        JPanel sizePanel2 = new JPanel();
        continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(150,75));
        sizePanel2.add(continueButton);
        continueButton.addActionListener(listener);

        JPanel sizePanel3 = new JPanel();
        helpButton = new JButton("Help");
        helpButton.setPreferredSize(new Dimension(150,75));
        sizePanel3.add(helpButton);
        helpButton.addActionListener(listener);
        
        this.add(titleLabel);
        this.add(sizePanel1);
        this.add(sizePanel2);
        this.add(sizePanel3);
    }
}
