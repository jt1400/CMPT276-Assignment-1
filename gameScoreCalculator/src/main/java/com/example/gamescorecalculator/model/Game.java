package com.example.gamescorecalculator.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    private int numberOfPLayers;
    private LocalDateTime localDateTime;
    public List<PlayerScore> playerScores = new ArrayList<>();

    public void setNumberOfPLayers(int numberOfPLayers) {
        if(numberOfPLayers < MIN_NUMBER_OF_PLAYERS){
            throw new IllegalArgumentException("Please enter a value that is "
                    + MIN_NUMBER_OF_PLAYERS + " or greater.");
        }
        else if (numberOfPLayers > MAX_NUMBER_OF_PLAYERS){
            throw new IllegalArgumentException("Please enter a value that is "
                    + MAX_NUMBER_OF_PLAYERS + " or less.");
        }
        else {
            this.numberOfPLayers = numberOfPLayers;
        }
    }

    public Game() {
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getWinner() {
        int highestScore = playerScores.get(0).getScore();

        int j = 0;
        for (int i = 1; i < numberOfPLayers; i++){
            if (playerScores.get(i).getScore() > highestScore){
                highestScore = playerScores.get(i).getScore();
                j = i;
            }
        }

        String winner = Integer.toString(j + 1);

        for (int i = 0; i < numberOfPLayers; i++){
            if ((playerScores.get(i).getScore() == highestScore) && (i != j)){
                winner += ", " + Integer.toString(i + 1);
            }
        }
        return winner;
    }

    public void addPlayer(PlayerScore playerScore) {
        playerScores.add(playerScore);
    }

    @Override
    public String toString() {
        StringBuilder gameResult = new StringBuilder();
        for (int i = 1; i < numberOfPLayers; i++){
            gameResult.append(" vs ");
            gameResult.append(playerScores.get(i).getScore());
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String gameResultString = Integer.toString(playerScores.get(0).getScore()) + gameResult.toString();
        gameResultString += ", winner player(s): " + this.getWinner() + " (@" + this.getLocalDateTime().format(format) + ")";
        return gameResultString;
    }
}
