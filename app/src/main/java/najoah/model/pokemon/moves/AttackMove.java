package najoah.model.pokemon.moves;

public class AttackMove extends Move
{
    private int dmg;
    private boolean isSpecial;

    public AttackMove(String name, boolean isSpecial)
    {
        this.isSpecial = isSpecial;
        dmg = 5;
        super.name = name;
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