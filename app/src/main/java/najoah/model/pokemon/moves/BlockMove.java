package najoah.model.pokemon.moves;

import najoah.model.pokemon.moves.*;

public class BlockMove extends Move
{
    protected String name;
    protected int dmg;

    //move types can be "attack" or "block" --- made move 
    public BlockMove(String name, int dmg)
    {
        super(name,dmg);
    }

}
