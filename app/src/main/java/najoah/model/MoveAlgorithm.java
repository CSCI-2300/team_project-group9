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

    public void bustAMove(Pokemon user, Pokemon com)
    {
        Move userMove = user.getMove();
        Move comMove = com.getMove();
        boolean userisAttack = userMove instanceof AttackMove;
        boolean comisAttack = comMove instanceof AttackMove;
        
        //this is where code for type checks, dmg calculations and edits of health
        //gating if both are blocks
        if(comisAttack && userisAttack)
        {
            //if neither are blocks
            com.adjustHealth(userMove.getDmg());
            user.adjustHealth(comMove.getDmg());

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
    public void attacked(Pokemon attacker, Pokemon defender)
    {
        //if non special 
        if(attacker.getMove().isSpecial())
        {
            defender.adjustHealth(attacker.getMove().getDmg()*2);
            return;
        }
        //user takes reduced dmg if blocking, com takes some recoil
        defender.adjustHealth(attacker.getMove().getDmg()/4);
        attacker.adjustHealth(attacker.getMove().getDmg()/2);


    }

}

