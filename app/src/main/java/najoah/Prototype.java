package najoah;

import java.awt.*;
import javax.swing.*;

public class Prototype
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private ImageIcon pikachu;
    //private ImageIcon bluePokemon;
    JLabel pikachuLabel;

    public Prototype()
    {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(400, 400));
        mainPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(400,75));

        JButton basic = new JButton("Basic Attack");
        JButton special = new JButton("Special Attack");
        JButton block = new JButton("Block");

        //Add rest of prototype here

        bottomPanel.add(basic);
        bottomPanel.add(special);
        bottomPanel.add(block);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }
}