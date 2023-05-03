package najoah.model.pokemon;

import najoah.model.pokemon.moves.*;
import java.io.Serializable;
import java.util.Random;
/*
pokemon class, this class will have moves, those moves will be children of a 
superclass of Move, so we have basicMove, specialMove, and blockMove
after model is alerted of a selection by both the computer and the user, 
the option can be made here


*/
public class Pokemon implements Serializable
{   
    private String name;
    Random rand = new Random();
    //this is all the standard rn
    private Move basic;
    private Move special;
    private Move block;

    private int healthMax;
    private int healthCurrent;

    private int energyCurrent;
    private int energyMax;
    //this is to send the move selected to the model, to the move algorithm
    private Move selected;
    private int rand_Poke;

    public Pokemon(String name)
    {
        rand_Poke = rand.nextInt(4);
        int rand_Dmg_Pool = rand.nextInt(40 - 9) + 10;
        int rand_Energy = rand.nextInt(70- rand_Dmg_Pool - 5) + 6;
        int rand_Health = rand.nextInt(70 - rand_Energy - 9) +10;
        this.name = name;

        energyCurrent = rand_Energy;
        energyMax = energyCurrent;

        healthMax = rand_Health;
        healthCurrent = healthMax;

        basic = new Move("Basic Attack",rand_Dmg_Pool/2);
        special = new Move("Special Attack",rand_Dmg_Pool/3);
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

    public int getType()
    {
        return this.rand_Poke; 
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


