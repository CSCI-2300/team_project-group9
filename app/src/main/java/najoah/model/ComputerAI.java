package najoah.model;

import najoah.model.pokemon.Pokemon;

import java.util.Random;
import java.io.Serializable;

//Class that will create a computer AI that will randomly select the next move

public class ComputerAI implements Serializable
{

    private Pokemon pokemonCom;
    private int i;
    public ComputerAI()
    {
        i = 1;
        pokemonCom = new Pokemon("Computer");
    }

    /** randomly selects the next move and returns it as a string. 
    * Move selection is weighted, basicAttack-40%, block-40%, specialAttack-20%.
    **/

    public void nextMove()
    {
        Random randomizer = new Random();

        int num = randomizer.nextInt(100);
        
        if (num < 26)
        {
            pokemonCom.makeMove(0);
        }
        else if (num >= 26 && num <= 51)
        {
            pokemonCom.makeMove(1);
        }
        else if (num > 51)
        {
            pokemonCom.makeMove(2);
        }

    }

    public void genNewPokemon()
    {
        this.pokemonCom = new Pokemon("Computer "+ i);
        i++;
    }
    //setting a new pokemon for Ai for next battle
    public void setPokemon(Pokemon newPoke)
    {
        this.pokemonCom = newPoke;
    }

    //getting the pokemon the ai currently has
    public Pokemon getPokemon()
    {
        return pokemonCom;

    }
}