package com.example.gamescorecalculator.model;

/*
Player score: Represents the score of a single player during a game.
See section 1.1 Game Background for the information to store
Constraints:
Number of cards, sum of points, and number of wager cards must each be nonnegative.
If there are 0 cards, then the sum of points and number of wager cards must be 0.
Beyond this, you don’t need to add constraints on the number of cards vs points vs
number of wager cards. For example, your program need not detect that with 2
cards one could not have 1000 points or 3 wager cards.
The class must enforce constraints on each of its values using exceptions. For
example:
if (month > 12) {
 throw new IllegalArgumentException("Month must be 12 or less");
}
Calculate the player’s score.
 */

public class PlayerScore {
    private int numberOfCards;
    private int sumOfPoints;
    private int numberOfWagerCards;

}
