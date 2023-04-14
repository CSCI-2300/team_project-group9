package najoah.model;



/*
this will be our Model, in here all other logical classes will be held
whenever an action occurs that would need to change logic, it is done through
this class
such as asking user, and ai to make a move
calling bustAMove() with user's pokemon and ai's pokemon as params


*/
public class Model
{
    private ComputerAI com;
    private MoveAlgorithm moveMagic;


    public Model()
    {
        com = new ComputerAI();
        moveMagic = new MoveAlgorithm();
    }



}