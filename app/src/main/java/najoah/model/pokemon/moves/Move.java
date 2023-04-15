package najoah.model.pokemon.moves;


//setting this up as a super class to be used later for passing args
public class Move
{
    protected String name;

    //move types can be "attack" or "block"
    public Move(String name)
    {
        this.name = name; 
    }

    public String getName()
    {
        return name;
    }

}