package com.example.gamescorecalculator.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
Game: Represents one game played by 1 to 4 players. Also stores the date/time when
the Game was created.
You must use the LocalDateTime class to store its creation date/time.
Must be able to report which player(s) won
 */

public class Game{
    private static final int MIN_NUMBER_OF_PLAYERS = 1;
    private static final int MAX_NUMBER_OF_PLAYERS = 4;

    private int numberOfPLayer;
    private LocalDateTime localDateTime;
    public List<PlayerScore> playerScores = new ArrayList<>();

    public void setNumberOfPLayer(int numberOfPLayers) {
        if(numberOfPLayers < MIN_NUMBER_OF_PLAYERS){
            throw new IllegalArgumentException("Please enter a value that is "
                    + MIN_NUMBER_OF_PLAYERS + " or greater.");
        }
        else if (numberOfPLayers > MAX_NUMBER_OF_PLAYERS){
            throw new IllegalArgumentException("Please enter a value that is "
                    + MAX_NUMBER_OF_PLAYERS + " or less.");
        }
    }

    public Game() {
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getWinner() {
        int maxScore = playerScores.get(0).getScore();

        for (int i = 1; i < numberOfPLayer; i++){
            // get winner
        }
        return "";
    }

    public void addPlayer(PlayerScore playerScore) {
        playerScores.add(playerScore);
    }

    @Override
    public String toString() {
        String gameResult = Integer.toString(playerScores.get(0).getScore());
        for (int i = 1; i < numberOfPLayer; i++){
            gameResult += " vs " + Integer.toString(playerScores.get(i).getScore());
        }
        gameResult += ", winner player(s): ";
        return "";
    }
}
