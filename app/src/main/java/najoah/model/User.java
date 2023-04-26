package najoah.model;

import najoah.model.pokemon.Pokemon;
import najoah.model.pokemon.moves.*;

import java.util.Vector;

//class will create a user that saves user wins and losses and pokemon history

public class User {
    private Pokemon pokemon;

    private Vector<Pokemon> pokemons;
    private int wins;
    private int losses;

    public User() {
        this.pokemon = new Pokemon();
        this.pokemons = new Vector<>();
        this.wins = 0;
        this.losses = 0;
    }

    public void makeMove(int num) 
    {
        // Use the selected move to attack the opponent's Pokemon
        pokemon.makeMove(num);
       
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

    // Method here to add a pokemon to the vector
    public void addPokemon(Pokemon pokemon)
    {
        pokemons.add(pokemon);
    }

    private void setNewPokemon()
    {
        this.pokemon = pokemons.get(0);
    }

    //Method to switch pokemon if user loses current pokemon
    public boolean switchPokemon()
    {
        pokemons.remove(0);
        if(pokemons.isEmpty()){
            return false;
        }
        this.setNewPokemon();
        return true;

    }

}

