package najoah.model.pokemon.moves;


//setting this up as a super class to be used later for passing args
public class Move
{
    protected String name;
    int dmg;

    //move types can be "attack" or "block" --- made move 
    public Move(String name, int dmg)
    {
        this.name = name;
        this.dmg = dmg; 
    }

    public String getName()
    {
        return name;
    }

    public int getDmg()
    {
        return 0;
    }
    
    public boolean getIsSpecial()
    {
        return false;
    }
    
}