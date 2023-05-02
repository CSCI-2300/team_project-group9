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
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JPanel helpPanel;
    private StartScreen startScreen;

    private JLabel moveLabel;
    private Controller controller;
    private Model model;
    private HealthBarPanel playerPanel;
    private HealthBarPanel compPanel;

    private Pokemon []pokes;

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


        //making proper frame
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //making main panel
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800, 400));
        mainPanel.setLayout(new BorderLayout());

        //making the two panels top and bottum
        bottomPanel = new JPanel();
        topPanel = new JPanel();
        topPanel.setLayout(null);

        topPanel.setPreferredSize(new Dimension(800,300));
        bottomPanel.setPreferredSize(new Dimension(300,75));
        
        //making move Label
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.moveLabel = new JLabel();
        this.moveLabel.setBorder(border);
        this.moveLabel.setVerticalAlignment(JLabel.BOTTOM);

        //creating moves
        JButton basic = new JButton("Basic Attack");
        basic.setPreferredSize(new Dimension(150,25));
        basic.addActionListener(this);

        JButton special = new JButton("Special Attack");
        special.setPreferredSize(new Dimension(150,25));
        special.addActionListener(this);

        JButton block = new JButton("Block");
        block.setPreferredSize(new Dimension(150,25));
        block.addActionListener(this);

        JButton catchButton = new JButton("Catch");
        catchButton.setPreferredSize(new Dimension(150,25));
        catchButton.addActionListener(this);

        //making seperate pokemon panels
        this.playerPanel = new HealthBarPanel(model.getPokemon()[0].getName(), model.getPokemon()[0].getHealthMax(),model.getPokemon()[0].getEnergyMax());
        
        this.compPanel = new HealthBarPanel(model.getPokemon()[1].getName(), model.getPokemon()[1].getHealthMax(),model.getPokemon()[1].getEnergyMax());

        //making energy bar
        //this can be relatively hardcoded, or we can set this too be scaled as aratio off of main panel size/frame
        playerPanel.setBounds(70,30,150,230);
        compPanel.setBounds(600,30,150,230);

        layering.add(forestLabel,0);
        layering.add(playerPanel,0);
        layering.add(compPanel,0);
    
        topPanel.add(layering);

        bottomPanel.add(moveLabel);
        bottomPanel.add(basic);
        bottomPanel.add(special);
        bottomPanel.add(block);
        bottomPanel.add(catchButton);
        bottomPanel.add(moveLabel);
       
        startScreen = new StartScreen(this);

        //mainPanel.add(topPanel, BorderLayout.CENTER);
        //mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(startScreen);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }


    //Gets input from user and returns selected move as a string
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        String input = button.getText();
        if (input == "New Game" || input == "Continue" || input == "Help" || input == "Back")
        {
            startScreenLogic(input);
        }
        else
        {
        //tell controller about selected move
        this.controller.playTurn(input);
        }
    }

    public void update()
    {
        pokes = model.getPokemon();
        this.playerPanel.setHP(pokes[0].getHealthCurrent(),pokes[0].getHealthMax());
        this.compPanel.setHP(pokes[1].getHealthCurrent(),pokes[1].getHealthMax());

        this.playerPanel.setEnergy(pokes[0].getEnergyCurrent(),pokes[0].getEnergyMax());
        this.compPanel.setEnergy(pokes[1].getEnergyCurrent(),pokes[1].getEnergyMax());

        this.playerPanel.setOwner(model.getPokemon()[0].getName());
        this.compPanel.setOwner(model.getPokemon()[1].getName());
    
        this.moveLabel.setText("The user performed a "+pokes[0].getMove().getName()+"."+" The computer perfomed a "+pokes[1].getMove().getName()+".");

        this.displayEndScreen(model.gameStatus());
    }

    public void displayEndScreen(boolean status)
    {
        if(status)
        {
            GameOverScreen gameOverPanel = new GameOverScreen(false, model.getWinLoss()[0], model.getWinLoss()[1]);
            topPanel.setVisible(false);
            bottomPanel.setVisible(false);
            mainPanel.add(gameOverPanel);
        }
    }

    public void startScreenLogic(String input)
    {
        if (input == "New Game")
        {
            startScreen.setVisible(false);
            mainPanel.add(topPanel, BorderLayout.CENTER);
            mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        }

        //have to implement continue 

        if (input == "Help")
        {
            startScreen.setVisible(false);
            helpPanel = new JPanel();
            //Noah you can input help info in below label
            JLabel helpLabel = new JLabel("Input Help here");
            JButton backButton = new JButton("Back");
            backButton.addActionListener(this);
            helpPanel.add(helpLabel);
            helpPanel.add(backButton);
            mainPanel.add(helpPanel);
        }

        if (input == "Back")
        {
            helpPanel.setVisible(false);
            startScreen.setVisible(true);
        }
    }
}

