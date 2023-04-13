package najoah.model;


/*
pokemon class, this class will have moves, those moves will be children of a 
superclass of Move, so we have basicMove, specialMove, and blockMove
after model is alerted of a selection by both the computer and the user, 
the option can be made here


*/
public class Pokemon
{   
    AttackMove basic;
    AttackMove special;
    Move block;

    Move selected;

    public Pokemon()
    {
        basic = new AttackMove("basic",false);
        special = new AttackMove("special",true);
        block = new move("block");
    }



    //this selected the move to be later returned to the move algortihm
    public void makeMove(int num)
    {
        swtich(num)
        {
            case 0:
                selected = basic;
                break;
            case 1:
                selected = special;
                break;
            case 2:
                selected = block;
                break;
        }

    }
    
    public Move getMove()
    {
        return selected;
    }

} 


