package com.example.gamescorecalculator.model;

import java.time.LocalDateTime;

/*
Game: Represents one game played by 1 to 4 players. Also stores the date/time when
the Game was created.
You must use the LocalDateTime class to store its creation date/time.
Must be able to report which player(s) won
 */

public class Game {
    private int numberOfPLayer;
    private LocalDateTime localDateTime;
    private int winner;

    public Game(int numberOfPLayer) {
        this.numberOfPLayer = numberOfPLayer;
        this.localDateTime = LocalDateTime.now();

        switch(numberOfPLayer){
            case 1:

        }

    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "";
    }
}
