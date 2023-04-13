package najoah.model;

import java.util.Random;

//Class that will create a computer AI that will randomly select the next move

public class ComputerAI
{

    private Pokemon pokemonCom;

    public ComputerAI()
    {
        
        pokemonCom = new Pokemon();
    }

    /** randomly selects the next move and returns it as a string. 
    * Move selection is weighted, basicAttack-40%, block-40%, specialAttack-20%.
    **/

    public void NextMove()
    {
        Random randomizer = new Random();

        int num = randomizer.nextInt(100);
        
        if (num < 40)
        {
            pokemonCom.makeMove(0);
        }
        else if (num >= 40 && num <= 79)
        {
            pokemonCom.makeMove(1);
        }
        else if (num > 79)
        {
            pokemonCom.makeMove(2);
        }

    }
}