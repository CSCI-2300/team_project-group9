package najoah.model;
import najoah.model.pokemon.Pokemon;
import najoah.model.pokemon.moves.*;
/*
this is where we will do the math on the moves selected, i think it would be best
if we passed the moves, in their entirety to this class, as moves will
have some level of uniqieness between pokemon

*/

//TODO: may need to check for health to avoid negative nums, maybe set bounds
// or this could be done in GUI even if internal is negative
public class MoveAlgorithm
{
    public MoveAlgorithm()
    {

    }

    //this will change the values of health and etc. based on math for moves
    public void bustAMove(Pokemon user, Pokemon com)
    {
        boolean userisAttack = user.getMove().getName().equals("Basic Attack") 
        || user.getMove().getName().equals("Special Attack");

        boolean comisAttack = com.getMove().getName().equals("Basic Attack") 
        || com.getMove().getName().equals("Special Attack");



        //removing energy or health for com and user based on move chosen
        switch(com.getMove().getName())
        {
            case "Basic Attack":
                com.adjustEnergy(4);
                if(com.getEnergyCurrent() < 0){com.adjustHealth(4);}
                break;

            case "Special Attack":
                com.adjustEnergy(4);
                if(com.getEnergyCurrent() < 0){com.adjustHealth(6);}
                break;

                
            case "Block":
                com.adjustEnergy(3);
                if(com.getEnergyCurrent() < 0){com.adjustHealth(3);}
                break;
        }

        switch(user.getMove().getName())
        {
            case "Basic Attack":
                user.adjustEnergy(4);
                if(user.getEnergyCurrent() < 0){user.adjustHealth(4);}
                break;

            case "Special Attack":
                user.adjustEnergy(4);
                if(user.getEnergyCurrent() < 0){user.adjustHealth(6);}
                break;

                
            case "Block":
                user.adjustEnergy(3);
                if(user.getEnergyCurrent() < 0){user.adjustHealth(3);}
                break;
        }

        System.out.println(user.getMove().getName()+ " " + com.getMove().getName());
        //this is where code for type checks, dmg calculations and edits of health
        //gating if both are blocks
        if(comisAttack && userisAttack)
        {

            //if neither are blocks
            com.adjustHealth(user.getMove().getDmg());
            if(com.getHealthCurrent() <= 0)
                return;
            user.adjustHealth(com.getMove().getDmg());

        }
        else if (comisAttack)
        {
            this.attacked(com,user);

        }
        else if (userisAttack)
        {
            this.attacked(user,com);

        }
        else
        {
            //if neither attack, both block, maybe exhaust dmg?
            com.adjustHealth(com.getHealthMax()/10);
            user.adjustHealth(user.getHealthMax()/10);
        }
    }


    //if an attack carries out, one defends one does not
    private void attacked(Pokemon attacker, Pokemon defender)
    {
        //if non special 

        // Joe: ^ shouldn't this below conditional before special move because it's doubling the damage?
        if(attacker.getMove().getName().equals("Special Attack"))
        {
            defender.adjustHealth(attacker.getMove().getDmg()*2);
            return;
        }
        //user takes reduced dmg if blocking, com takes some recoil
        defender.adjustHealth(attacker.getMove().getDmg()/4);
        attacker.adjustHealth(attacker.getMove().getDmg()/2);


    }

}

