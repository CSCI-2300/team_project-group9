package najoah.model;

import najoah.model.pokemon.*;
import najoah.gui.GameGUI;
/*
this will be our Model, in here all other logical classes will be held
whenever an action occurs that would need to change logic, it is done through
this class
such as asking user, and ai to make a move
calling bustAMove() with user's pokemon and ai's pokemon as params


*/
public class Model
{
    private ComputerAI com;
    private User user;
    private MoveAlgorithm moveMagic;
    private CatchAlgorithm catchMagic;
    private GameGUI gui;
    private String winner;

    public Model()
    {
        com = new ComputerAI();
        moveMagic = new MoveAlgorithm();
        catchMagic = new CatchAlgorithm();
        user = new User();
        
    }

    public void turn(String move)
    {
        if (move == "Catch")
        {
            catchMagic.attemptCatch(user,com);
        }
        else
        {
            this.userTurn(move);
            com.nextMove();
            moveMagic.bustAMove(user.getPokemon(),com.getPokemon());
            
            if(user.getPokemon().getHealthCurrent() <= 0)
            {
                if(!user.swapPokemon())
                {
                    //add game ending here
                }

            }

            if(com.getPokemon().getHealthCurrent() <= 0)
            {
                //gen new comp here, reset our health

            }
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

    public Pokemon[] getPokemon()
    {
        Pokemon[] arr ={user.getPokemon(),com.getPokemon()};

        return arr;
    }

    private void updateGui()
    {
        gui.update();
    }
    
    public void register(GameGUI gui)
    {
        this.gui = gui;
    }
}

