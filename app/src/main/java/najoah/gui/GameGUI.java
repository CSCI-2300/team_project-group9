package najoah.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

import najoah.controller.*;
import najoah.model.*;
import najoah.model.pokemon.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class GameGUI implements ActionListener
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel moveLabel;
    private ImageIcon pikachu;
    private Controller controller;
    private Model model;
    private HealthBarPanel playerHP;
    private HealthBarPanel computerHP;

    private JLayeredPane layering;

    private BufferedImage forestImage;
    private JLabel forestLabel;

    /*########################################3
    we need to redo a bit of this, 
    one, make a background class that can create the image and load it to a layered panel
    two, load health and pokemon into one class panel
    three, load both pokemon wiht health onto the background class
    four, load background as top panel


    ##############
    lets try to make it as little hardcoded as possible so we can edit and change health bar size
    with little code rewrite
    */
   
    

    public GameGUI(Model model, Controller controller)
    {
        this.controller = controller;
        this.model = model;

        forestLabel = new JLabel();
        InputStream input = getClass().getClassLoader().getResourceAsStream("Drawing 3.png");
        try
        {
            forestImage = ImageIO.read(input);
            forestLabel.setIcon(new ImageIcon(new ImageIcon(forestImage).getImage().getScaledInstance(768, 256, Image.SCALE_DEFAULT)));
            forestLabel.setBounds(30,8,769,257);
            //forestLabel.setOpaque(true);
            //forestLabel.setLayout(new BorderLayout());
        }
        catch(Exception e){}

        layering = new JLayeredPane();
        //layering.setPreferredSize(new Dimension(770,300));
        layering.setBounds(0,0,770,300);
    
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800, 400));
        mainPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);

        //topPanel.setPreferredSize(new Dimension(800,300));
        bottomPanel.setPreferredSize(new Dimension(300,75));
        
        //trying to make pokemon appear horizontal to each other healthbar code  bugged
        //topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        this.moveLabel = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.moveLabel.setBorder(border);
        this.moveLabel.setVerticalAlignment(JLabel.BOTTOM);

        JButton basic = new JButton("Basic Attack");
        basic.addActionListener(this);
        JButton special = new JButton("Special Attack");
        special.addActionListener(this);
        JButton block = new JButton("Block");
        block.addActionListener(this);

        this.playerHP = new HealthBarPanel("Player", 50);
        this.computerHP = new HealthBarPanel("Computer", 50);
        
        //this can be relatively hardcoded, or we can set this too be scaled as aratio off of main panel size/frame
        playerHP.setBounds(70,40,150,176);
        computerHP.setBounds(600,40,150,176);
        layering.add(forestLabel,0);
        layering.add(playerHP,0);
        layering.add(computerHP,0);
       
        topPanel.add(layering);

        bottomPanel.add(moveLabel);
        bottomPanel.add(basic);
        bottomPanel.add(special);
        bottomPanel.add(block);
        bottomPanel.add(moveLabel);
       

        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }


    //Gets input from user and returns selected move as a string
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        String move = button.getText();

        //tell controller about selected move
        this.controller.playTurn(move);
    }

    public void update()
    {
        Pokemon[] pokes = model.getPokemon();
        this.playerHP.changeHealth(pokes[0].getHealthCurrent());
        this.playerHP.lowerHealthBar();
        this.computerHP.changeHealth(pokes[1].getHealthCurrent());
        this.computerHP.lowerHealthBar();

        this.moveLabel.setText("The user performed a "+pokes[0].getMove().getName()+". The computer perfomed a "+pokes[1].getMove().getName()+".");
    }

}