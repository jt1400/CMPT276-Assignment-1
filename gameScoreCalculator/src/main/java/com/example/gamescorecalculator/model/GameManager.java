/*
GameManager class
*/

package com.example.gamescorecalculator.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameManager implements Iterable<Game>{
    private List<Game> games = new ArrayList<>();

    public void add(Game game) {
        games.add(game);
    }

    public int numberOfGames(){
        return games.size();
    }

    @Override
    public Iterator<Game> iterator() {
        return games.iterator();
    }

    public void delete(int n){
        if(n < 0){
            throw new IllegalArgumentException("Please enter a value that is 0 or greater.");
        }
        else if (n > games.size()){
            throw new IllegalArgumentException("Please enter a value that is " + games.size() + " or less.");
        }
        else {
            games.remove(n - 1);
        }
    }
}
