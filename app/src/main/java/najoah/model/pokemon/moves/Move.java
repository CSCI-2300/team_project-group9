package najoah.model.pokemon;

public class Move()
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