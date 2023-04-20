package najoah.model.pokemon.moves;


//setting this up as a super class to be used later for passing args
public class Move
{
    protected String name;

    //move types can be "attack" or "block" --- made move 
    public Move(String name)
    {
        this.name = name; 
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

// Below is what I assume you were meaning for a struct? This is how I found to do it.
// I haven't worked with structs before but you can take a look and use it or delete it idc.

/* public class Move {
    private String name;
    private int dmg;
    private boolean isSpecial;

    // Constructor for attack moves
    public Move(String name, int dmg, boolean isSpecial) {
        this.name = name;
        this.dmg = dmg;
        this.isSpecial = isSpecial;
    }

    // Constructor for block moves
    public Move(String name) {
        this.name = name;
        this.dmg = 0;
        this.isSpecial = false;
    }

    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    public boolean getIsSpecial() {
        return isSpecial;
    }
} */
