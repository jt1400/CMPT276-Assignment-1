package com.example.gamescorecalculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerScoreTest {

    @Test
    void testGetNumberOfCards() {
        PlayerScore p = new PlayerScore();
        p.setNumberOfCards(8);
        assertEquals(8, p.getNumberOfCards());
    }

    @Test
    void testGetSumOfCards() {
        PlayerScore p = new PlayerScore();
        p.setSumOfCards(10);
        assertEquals(10, p.getSumOfCards());
    }

    @Test
    void testGetNumberOfWagerCards() {
        PlayerScore p = new PlayerScore();
        p.setNumberOfWagerCards(2);
        assertEquals(2, p.getNumberOfWagerCards());
    }

    @Test
    void testGetScore(){
        PlayerScore p = new PlayerScore();
        p.setNumberOfWagerCards(2);
        p.setNumberOfCards(8);
        p.setSumOfCards(30);
        assertEquals(50, p.getScore());
    }

    @Test
    void testGetScoreWithZeroCard(){
        PlayerScore p = new PlayerScore();
        p.setNumberOfCards(0);
        assertEquals(0, p.getScore());
    }

    @Test
    void testGetScoreWithOneCard(){
        PlayerScore p = new PlayerScore();
        p.setNumberOfCards(1);
        p.setSumOfCards(1);
        p.setNumberOfWagerCards(1);
        assertEquals(-38, p.getScore());
    }

    @Test
    void testSetBadNumberOfCards(){
        PlayerScore p = new PlayerScore();
        assertThrows(IllegalArgumentException.class,
                () -> p.setNumberOfCards(-1));
    }

    @Test
    void testSetBadNumberOfWagerCards(){
        PlayerScore p = new PlayerScore();
        assertThrows(IllegalArgumentException.class,
                () -> p.setNumberOfWagerCards(-1));
    }

    @Test
    void testSetBadSumOfCards(){
        PlayerScore p = new PlayerScore();
        assertThrows(IllegalArgumentException.class,
                () -> p.setSumOfCards(-1));
    }
}