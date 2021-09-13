package com.example.gamescorecalculator.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameManager implements Iterable<Game>{
    private List<Game> games = new ArrayList<>();

    public void add(Game game) {
        games.add(game);
    }

    @Override
    public Iterator<Game> iterator() {
        return games.iterator();
    }
}
