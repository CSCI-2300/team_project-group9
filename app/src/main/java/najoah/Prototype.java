package najoah;

import java.awt.*;
import javax.swing.*;

public class Prototype
{
    private JFrame mainFrame;
    private JPanel mainPanel;

    public Prototype()
    {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(400, 400));

        //Add rest of prototype here

        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}