package najoah.model.pokemon;

import najoah.model.pokemon.moves.*;
import java.io.Serializable;

/*
pokemon class, this class will have moves, those moves will be children of a 
superclass of Move, so we have basicMove, specialMove, and blockMove
after model is alerted of a selection by both the computer and the user, 
the option can be made here


*/
public class Pokemon implements Serializable
{   
    String name;

    //this is all the standard rn
    Move basic;
    Move special;
    Move block;

    int healthMax;
    int healthCurrent;

    int energyCurrent;
    int energyMax;
    //this is to send the move selected to the model, to the move algorithm
    Move selected;

    public Pokemon(String name)
    {
        this.name = name;

        energyCurrent = 10;
        energyMax = energyCurrent;

        healthMax = 50;
        healthCurrent = healthMax;

        basic = new Move("Basic Attack",6);
        special = new Move("Special Attack",4);
        block = new Move("Block",0);
        selected = basic;
    }



    //this selected the move to be later returned to the move algortihm
    public void makeMove(int num)
    {
        switch(num)
        {
            case 0:
                selected = basic;
                break;
            case 1:
                selected = special;
                break;
            case 2:
                selected = block;
                break;
        }

    }

    public void setMove(String type, int dmg)
    {
        this.selected = new Move(type,dmg);
    }

    public void adjustHealth(int delta)
    {
        this.healthCurrent -= delta;
    }

    public void adjustEnergy(int delta)
    {
        this.energyCurrent -= delta;
    }

    public Move getMove()
    {
        return selected;
    }

    public int getEnergyCurrent()
    {
        return this.energyCurrent;
    }

    public int getEnergyMax()
    {
        return this.energyMax;
    }
    
    public int getHealthMax()
    {
        return this.healthMax;
    }

    public int getHealthCurrent()
    {
        return this.healthCurrent;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
} 


