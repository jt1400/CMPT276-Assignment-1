package com.example.gamescorecalculator.ui;

import com.example.gamescorecalculator.model.Game;
import com.example.gamescorecalculator.model.GameManager;
import com.example.gamescorecalculator.model.PlayerScore;

import java.util.Scanner;


/*
Text UI must repeatedly display a menu with the following choices:
List known games
If there are no games yet, state “No games”
Display all the games, numbering them starting at 1.
Display each game in the format:
40 vs 40 vs -12, winner player(s): 1, 2 (@2021-08-31 13:37)
The score earned by each player, separated by “ vs ”
Comma separated list of winning players’ numbers (1-indexed).
Time stamp of when the game was created in format: yyyy-MM-dd HH:mm
Add a new game
Ask user for how many player, then for each player record the information about their
game’s score.
If the user enters 0 cards were played for a player, then do not ask about points or
wager cards.
Remove an existing game
Display a list of known games (same format as above)
Ask user to enter a game’s number to delete it.
Allow user to enter 0 to delete none.
Exit
Close the program
 */

public class TextUI {


    private final GameManager gameManager;
    private Scanner in = new Scanner(System.in);// Read from keyboard


    public TextUI(GameManager gameManager) {
        this.gameManager = gameManager;
    }


    public void showMenu() {
        System.out.println("Menu: \n-------------- " +
                "\n1. List games " +
                "\n2. New game " +
                "\n3. Delete game " +
                "\n0. Exit " +
                "\n:");
        int menuChoice = in.nextInt();

        while(menuChoice < 0 || menuChoice > 4){
            System.out.println("Invalid value.");
            if(menuChoice < 0){
                System.out.println("Please enter a value that is 0 or greater.");
            }
            else {
                System.out.println("Please enter a value that is 3 or less.");
            }
            menuChoice = in.nextInt();
        }

        switch(menuChoice){
            case 1:
                System.out.println("Games: " + "\n-------------- " + "\n");
                if(gameManager.numberOfGames() == 0){
                    System.out.println("\tNo games");
                }
                else{
                    int i = 1;
                    for(Game game : gameManager) {
                        System.out.println(i + ". " + game);
                    }
                }

            case 2:
                System.out.println("Adding game: " + "\n-------------- " + "\n");

                Game game = new Game();

                System.out.println("How many players?");
                int numberOfPlayers = in.nextInt();

                boolean repeat = true;
                while (repeat) {
                    try {
                        game.setNumberOfPLayer(numberOfPlayers);
                        repeat = false;
                    } catch (Exception e) {
                        System.out.println("Invalid value. \n" + e);
                    }
                }

                for(int i = 1; i <= numberOfPlayers; i++) {
                    PlayerScore player = new PlayerScore();

                    System.out.println("Player " + i + "\n\tHow many cards?");
                    int numberOfCards = in.nextInt();

                    repeat = true;
                    while (repeat) {
                        try {
                            player.setNumberOfCards(numberOfCards);
                            repeat = false;
                        } catch (Exception e) {
                            System.out.println("Invalid value. \n" + e);
                            numberOfCards = in.nextInt();
                        }
                    }

                    if (numberOfCards == 0) {
                        player.setSumOfCards(0);
                        player.setNumberOfWagerCards(0);
                        game.addPlayer(player);
                        continue;
                    }

                    System.out.println("\tSum of Cards?");
                    int sumOfCards = in.nextInt();
                    repeat = true;
                    while (repeat) {
                        try {
                            player.setSumOfCards(sumOfCards);
                        } catch (Exception e) {
                            System.out.println("Invalid value. \n" + e);
                            sumOfCards = in.nextInt();
                        }
                    }


                    System.out.println("\tHow many wagers?");
                    int numberOfWagerCards = in.nextInt();
                    repeat = true;
                    while (repeat) {
                        try {
                            player.setNumberOfWagerCards(numberOfWagerCards);
                        } catch (Exception e) {
                            System.out.println("Invalid value. \n" + e);
                            numberOfWagerCards = in.nextInt();
                        }

                        game.addPlayer(player);
                    }
                }
                System.out.println("Adding game:\n\t" + game);

            case 3:
                System.out.println("Games: " + "\n-------------- " + "\n");
                if(gameManager.numberOfGames() == 0){
                    System.out.println("\tNo game to delete");
                }
                else{
                    int i = 1;
                    for(Game g : gameManager) {
                        System.out.println(i + ". " + g);
                    }

                    System.out.println("Which game to delete (0 for none)?");
                    int gameToDelete = in.nextInt() - 1;
                    if(gameToDelete < 0 ||gameToDelete > gameManager.numberOfGames()){
                        System.out.println("Invalid value.");
                    }
                    else if(gameToDelete == 0){
                        this.showMenu();
                    }
                    gameManager.delete(gameToDelete);
                }

            case 0:
                System.out.println("DONE!");
                break;

            default:
                this.showMenu();
        }

    }

}
