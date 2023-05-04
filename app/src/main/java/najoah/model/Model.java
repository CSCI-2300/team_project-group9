package najoah.model;

import najoah.model.pokemon.*;
import java.io.IOException;
import java.io.*;

import java.io.Serializable;
import najoah.gui.ConfirmationDialog;
import najoah.gui.FileSelector;

import najoah.gui.GameGUI;
/*
this will be our Model, in here all other logical classes will be held
whenever an action occurs that would need to change logic, it is done through
this class
such as asking user, and ai to make a move
calling bustAMove() with user's pokemon and ai's pokemon as params


*/
public class Model implements Serializable
{
    private ComputerAI com;
    private User user;
    private MoveAlgorithm moveMagic;
    private CatchAlgorithm catchMagic;
    private boolean loss;

    public Model()
    {
        com = new ComputerAI();
        moveMagic = new MoveAlgorithm();
        catchMagic = new CatchAlgorithm();
        user = new User();
        loss = false;
    }

    public void turn(String move)
    {
        if (move == "Catch" && user.getPokemon().getHealthCurrent() > 0)
        {
            this.user.getPokemon().setMove("Catch",0);

            if(!catchMagic.attemptCatch(user, com)){
                this.com.nextMove();
                moveMagic.bustAMove(user.getPokemon(), com.getPokemon());
            }
            else{
                nextFight();
                this.com.getPokemon().setMove("breakout but failed, and was captured",0);
                this.user.win();
                return;
            }
            
        }
        else
        {
            this.userTurn(move);
            com.nextMove();
            moveMagic.bustAMove(user.getPokemon(), com.getPokemon());
            
        }
            if(user.getPokemon().getHealthCurrent() <= 0)
            {
                this.user.lose();
                if(!user.switchPokemon())
                {
                    this.loss = true;
                }
                return;
            }

            if(com.getPokemon().getHealthCurrent() <= 0)
            {
                //gen new comp here, reset our health
                this.user.getPokemon().setMove("finishing blow to the opponent",0);
                nextFight();
                this.com.getPokemon().setMove("good fight but lost",0);
                this.user.win();
            }
    }

    private void userTurn(String move)
    {
        
        switch(move)
        {
            case "Basic Attack":
                user.makeMove(0);
                break;

            case "Special Attack":
                user.makeMove(1);
                break;

            case "Block":
                user.makeMove(2);
                break;
        }

    }

    private void nextFight()
    {
        user.getPokemon().adjustEnergy(-(user.getPokemon().getEnergyMax()/2 - user.getPokemon().getEnergyCurrent()));
        com.genNewPokemon();
    }

    public Pokemon[] getPokemon()
    {
        Pokemon[] arr ={user.getPokemon(),com.getPokemon()};

        return arr;
    }

    public boolean gameStatus()
    {
        return loss;
    }

    public int[] getWinLoss()
    {
        int[]arr ={user.getWins(), user.getLosses()};
        return arr;
    }

    public User getUser()
    {
        return user;
    }

    public ComputerAI getComputer()
    {
        return com;
    }

    public void restart()
    {
        this.user = new User();
        this.com = new ComputerAI();
    }

    public void loadFromFile() throws IOException, ClassNotFoundException
    {
        String filePath = FileSelector.selectFileToLoad();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        user = (User)objectInputStream.readObject();
        com = (ComputerAI)objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("Loaded from file");
    }
}

