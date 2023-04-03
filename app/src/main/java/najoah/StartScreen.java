package najoah;

import java.awt.*;
import javax.swing.*;


public class StartScreen
{
    private JFrame mainFrame;
    private JPanel startPanel;
    private JButton newGameButton;
    private JButton continueButton;
    private BoxLayout boxLayout;
    private JPanel mainPanel;
    //private ImageIcon bluePokemon;
    JLabel pikachuLabel;

    public StartScreen() {
        mainFrame = new JFrame("NaJoAh");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(400, 400));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        startPanel = new JPanel();
        startPanel.setPreferredSize(new Dimension(200, 200));
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));

        newGameButton = new JButton("New Game");
        continueButton = new JButton("Continue");

        startPanel.add(Box.createVerticalGlue());
        startPanel.add(newGameButton);
        startPanel.add(continueButton);
        startPanel.add(Box.createVerticalGlue());

        startPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(startPanel);

        mainFrame.add(mainPanel);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
