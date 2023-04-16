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
    private GameGUI gui;

    public Model()
    {
        com = new ComputerAI();
        moveMagic = new MoveAlgorithm();
        user = new User();
    }

    public void turn(String move)
    {
        this.userTurn(move);
        com.nextMove();
        moveMagic.bustAMove(user.getPokemon(),com.getPokemon());


    }

    private void userTurn(String move)
    {
        
        switch(move)
        {
            case "basic":
                user.makeMove(0);
                break;

            case "special":
                user.makeMove(1);
                break;

            case "block":
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

