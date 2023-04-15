package najoah.model.pokemon.moves;


//setting this up as a super class to be used later for passing args
public interface Move
{
    protected String name;

    //move types can be "attack" or "block" --- made move 
    public Move(String name)
    { 
    }

    public String getName()
    {
    }

}