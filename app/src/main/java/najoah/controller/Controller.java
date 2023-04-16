package najoah.controller;

import najoah.model.*;
import najoah.model.pokemon.moves.Move;
import najoah.model.pokemon.Pokemon;
import najoah.gui.*;

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
    //protected Model model; 
    /// I don't know what to call for the player's move
    // Noah: here you take what button is pressed, and alert the model that a player has moved and pass the variable
    //ill build a user class to hold onto what the player owns so that model can acess it
    protected Pokemon user;
    protected Pokemon computer;
    protected ComputerAI comAI;
    protected MoveAlgorithm moveAlgorithm;

    public Controller(Pokemon user, ComputerAI comAI, MoveAlgorithm moveAlgorithm) /// 
    {
        this.user = user;
        this.comAI = comAI;
        this.moveAlgorithm = moveAlgorithm;
    }

    public void playTurn(Move playerMove) 
    {
        /* /// not sure how to reference the computer's move
        and how we are clearly differentiating the two */
        Move computerMove = comAI.NextMove();
        moveAlgorithm.bustAMove(user,computer);

        // should take in users input, call the computer's move
        // then send it to the moveAlgorithm to update health
    }
    
}