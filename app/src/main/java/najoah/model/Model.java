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
                this.user.getPokemon().adjustHealth(com.getPokemon().getMove().getDmg()+5);
                this.com.nextMove();
                return;
            }
            nextFight();
            this.com.getPokemon().setMove("breakout but failed, and was captured",0);
            this.user.win();
            user.getPokemon().adjustHealth(-(user.getPokemon().getHealthMax()-user.getPokemon().getHealthCurrent()));
            user.getPokemon().adjustEnergy(-(user.getPokemon().getEnergyMax()-user.getPokemon().getEnergyCurrent()));
        }
        else
        {
            this.userTurn(move);
            com.nextMove();
            moveMagic.bustAMove(user.getPokemon(), com.getPokemon());
            
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
        user.getPokemon().adjustHealth(-(user.getPokemon().getHealthMax()-user.getPokemon().getHealthCurrent()));
        user.getPokemon().adjustEnergy(-(user.getPokemon().getEnergyMax()-user.getPokemon().getEnergyCurrent()));
        com.genNewPokemon();
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

    public boolean gameStatus()
    {
        return loss;
    }

    public int[] getWinLoss()
    {
        int[]arr ={user.getWins(), user.getLosses()};
        return arr;
    }

}

