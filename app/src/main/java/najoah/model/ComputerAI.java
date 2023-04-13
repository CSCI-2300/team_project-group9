package najoah.model;

import java.util.Random;

//Class that will create a computer AI that will randomly select the next move

public class ComputerAI
{
    private String nextMove;

    public ComputerAI()
    {
        nextMove = "";
    }

    /** randomly selects the next move and returns it as a string. 
    * Move selection is weighted, basicAttack-40%, block-40%, specialAttack-20%.
    **/

    public String getNextMove()
    {
        Random randomizer = new Random();

        int num = randomizer.nextInt(100);
        
        if (num < 40)
        {
            nextMove = "basicAttack"; 
        }
        else if (num >= 40 && num <= 79)
        {
            nextMove = "block";
        }
        else if (num > 79)
        {
            nextMove = "specialAttack";
        }

        return nextMove;
    }
}