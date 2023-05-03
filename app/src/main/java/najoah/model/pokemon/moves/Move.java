package najoah.model.pokemon.moves;
import java.io.Serializable;


//setting this up as a super class to be used later for passing args
public class Move implements Serializable
{
    protected String name;
    protected int dmg;

    //move types can be "attack" or "block" --- made move 
    public Move(String name, int dmg)
    {
        this.name = name;
        this.dmg = dmg; 
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public int getDmg()
    {
        return dmg;
    }

    public void setDmg(int dmg)
    {
        this.dmg = dmg;
    }
    
}