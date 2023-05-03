package najoah.controller;

import najoah.model.*;
import najoah.model.pokemon.moves.Move;
import najoah.model.pokemon.Pokemon;

import java.io.IOException;
import java.io.*;

import najoah.gui.*;

import najoah.gui.ConfirmationDialog;
import najoah.gui.FileSelector;

/* The user presses an attack in the view layer of the application.
The view layer notifies the controller of the attack selection.
The controller requests the computer's move selection from the model layer.
The model layer uses an algorithm to select a move for the computer based on the game logic and returns the result to the controller.
The controller receives both the user's and the computer's move selections and sends them to the model layer to compute the result of the attack.
The model layer uses the algorithm to calculate the outcome of the attack based on the selected moves and returns the result to the controller.
The controller updates the view layer with the results of the attack, such as the damage dealt and any status effects applied.
The view layer updates the game interface to reflect the changes in the game state, such as displaying the new health values of the player and the computer. */


public class Controller
{
    private Model gameModel;
    private GameGUI gameView;

    public Controller(Model gameModel) 
    {  
        this.gameModel = gameModel;
        start();
    }

    public void loadGame()
    {
        try 
        {
            this.gameModel.loadFromFile();
        }
        catch (Exception error)
        {
            System.out.println(error.getMessage());
        }
        this.gameView.update();
    }

    public void playTurn(String move) 
    {
        gameModel.turn(move);
        gameView.update();
    }

    private void start()
    {
        this.gameView = new GameGUI(this.gameModel,this);
    }

    public void userQuit()
    {
        if (!ConfirmationDialog.confirmSaveGame())
        {
            return;
        }
        try
        {
            String filePath = FileSelector.selectFileToSave();
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.gameModel.getUser());
            objectOutputStream.writeObject(this.gameModel.getComputer());
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}