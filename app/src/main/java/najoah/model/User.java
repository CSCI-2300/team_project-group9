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

    public Vector<Pokemon> getPokemons()
    {
        return pokemons;
    }

    //Method to switch pokemon if user loses current pokemon
    public void switchPokemon()
    {
        String noMorePoke = "No more pokemon";
        if (!pokemons.isEmpty())
        {
            pokemons.remove(0);

            if (!pokemons.isEmpty())
            {
               pokemons.get(0);
            }
            else 
            {
               emptyPokemon(noMorePoke);
            }
        }
        else
        {
            emptyPokemon(noMorePoke);
        }
    }

    public String emptyPokemon(String noMorePoke)
    {
        return noMorePoke;
    }

}

