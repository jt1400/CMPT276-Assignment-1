package com.example.gamescorecalculator.model;

import java.time.LocalDateTime;

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
}
