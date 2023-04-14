package najoah.model.pokemon;

import najoah.model.pokemon.moves.*;

/*
pokemon class, this class will have moves, those moves will be children of a 
superclass of Move, so we have basicMove, specialMove, and blockMove
after model is alerted of a selection by both the computer and the user, 
the option can be made here


*/
public class Pokemon
{   

    //this is all the standard rn
    AttackMove basic;
    AttackMove special;
    Move block;
    int healthMax;
    int healthCurrent;
    //this is to send the move selected to the model, to the move algorithm
    Move selected;

    public Pokemon()
    {
        healthMax = 50;
        healthCurrent = healthMax;
        basic = new AttackMove("basic",false);
        special = new AttackMove("special",true);
        block = new Move("block");
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

    public void adjustHealth(int delta)
    {
        this.healthCurrent -= delta;
    }
    
    public Move getMove()
    {
        return selected;
    }
    
    public int getHealthMax()
    {
        return this.healthMax;
    }

    public int getHealthCurrent()
    {
        return this.healthCurrent;
    }

} 


