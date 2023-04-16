package najoah.model.pokemon.moves;

import najoah.model.pokemon.moves.*;
//inhertis from move so can be passed in its place
public class AttackMove extends Move
{
    //definitions for how much dmg a attack move does and if it is special

    private int dmg;
    private boolean isSpecial;

    public AttackMove(String name, boolean isSpecial)
    {
        super(name);
        this.isSpecial = isSpecial;
        dmg = 6;
        
    }

    //used to find the dmg by the move alogrithm


    public void setDmg(int dmg)
    {
        this.dmg = dmg;
    }
        
    @Override
    public int getDmg()
    {
        return dmg;
    }

    //if a move is special the move algortihm will acount for that
    @Override
    public boolean getIsSpecial()
    {
        return isSpecial;
    }

}