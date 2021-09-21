/*
PlayerScore class
 */

package com.example.gamescorecalculator.model;

public class PlayerScore {
    private int numberOfCards;
    private int sumOfCards;
    private int numberOfWagerCards;

    public void setNumberOfCards(int numberOfCards) {
        if (numberOfCards < 0){
            throw new IllegalArgumentException("Please enter a value that is 0 or greater.");
        }

        this.numberOfCards = numberOfCards;
    }

    public void setSumOfCards(int sumOfCards) {
        if (sumOfCards < 0){
            throw new IllegalArgumentException("Please enter a value that is 0 or greater.");
        }

        this.sumOfCards = sumOfCards;
    }

    public void setNumberOfWagerCards(int numberOfWagerCards) {
        if (numberOfWagerCards < 0){
            throw new IllegalArgumentException("Please enter a value that is 0 or greater.");
        }

        this.numberOfWagerCards = numberOfWagerCards;
    }

    public int getScore() {
        int score = (sumOfCards - 20) * (numberOfWagerCards + 1);

        if (numberOfCards >= 8){
            score += 20;
        }

        if (numberOfCards == 0){
            score = 0;
        }

        return score;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public int getSumOfCards() {
        return sumOfCards;
    }

    public int getNumberOfWagerCards() {
        return numberOfWagerCards;
    }
}
