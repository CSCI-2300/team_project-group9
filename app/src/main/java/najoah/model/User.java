package najoah.model;

import najoah.model.pokemon.Pokemon;
import najoah.model.pokemon.moves.*;;

//class will create a user that saves user wins and losses and pokemon history

public class User {
    private Pokemon pokemon;
    private int wins;
    private int losses;

    public User(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.wins = 0;
        this.losses = 0;
    }

    public void makeMove(String move) 
    {
        // Use the selected move to attack the opponent's Pokemon
        int moveNumber = move.parseInt();
        pokemon.makeMove();
       
    }

    public void win() 
    {
        wins++;
    }

    public void lose() 
    {
        losses++;
    }

    public int getWins() 
    {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}

