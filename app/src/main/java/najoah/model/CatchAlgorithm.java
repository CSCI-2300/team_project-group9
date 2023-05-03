package najoah.model;

import najoah.model.pokemon.*;
import java.util.Random;
import java.io.Serializable;

public class CatchAlgorithm implements Serializable
{
    public CatchAlgorithm() 
    {

    }

    public boolean attemptCatch(User user, ComputerAI com)
    {
        boolean success = false;
        Pokemon comPokemon = com.getPokemon();
        Random randomizer = new Random();
        int currentHP = comPokemon.getHealthCurrent();
        int maxHP = comPokemon.getHealthMax();

        int catchRate = Math.round(((maxHP*3 - 2*currentHP-15)/maxHP*3)*10);
        int num = randomizer.nextInt(100)+1;

        if (num <= catchRate)
        {
            success = true;
            user.addPokemon(comPokemon);
            System.out.println("Player caught the Pokemon");
        }
        return success;
    }
}
