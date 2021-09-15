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

package com.example.gamescorecalculator.ui;

import com.example.gamescorecalculator.model.Game;
import com.example.gamescorecalculator.model.GameManager;
import com.example.gamescorecalculator.model.PlayerScore;

import java.util.Scanner;


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

        while((menuChoice < 0) || (menuChoice > 4)){
            System.out.println("Invalid value.");
            if(menuChoice < 0){
                System.out.println("Please enter a value that is 0 or greater.\n:");
            }
            else {
                System.out.println("Please enter a value that is 3 or less.\n:");
            }
            menuChoice = in.nextInt();
        }

        System.out.println("\n");

        switch(menuChoice){
            case 1:
                System.out.println("Games: " + "\n-------------- ");
                if(gameManager.numberOfGames() == 0){
                    System.out.println("\tNo games");
                }
                else{
                    int i = 1;
                    for(Game game : gameManager) {
                        System.out.println(i + ". " + game);
                        i++;
                    }
                }
                System.out.println("\n");
                this.showMenu();
                break;

            case 2:
                Game game = new Game();

                System.out.println("How many players?");
                int numberOfPlayers = in.nextInt();

                boolean repeat = true;
                while (repeat) {
                    try {
                        game.setNumberOfPLayers(numberOfPlayers);
                        repeat = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid value. \n" + e.getMessage() + "\nHow many players?");
                        numberOfPlayers = in.nextInt();
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
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid value. \n" + e.getMessage()
                                    + "\nPlayer " + i + "\n\tHow many cards?");
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
                            repeat = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid value. \n" + e.getMessage() + "\n\tSum of Cards?");
                            sumOfCards = in.nextInt();
                        }
                    }


                    System.out.println("\tHow many wagers?");
                    int numberOfWagerCards = in.nextInt();
                    repeat = true;
                    while (repeat) {
                        try {
                            player.setNumberOfWagerCards(numberOfWagerCards);
                            repeat = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid value. \n" + e.getMessage() + "\n\tHow many wagers?");
                            numberOfWagerCards = in.nextInt();
                        }
                    }
                    game.addPlayer(player);
                }
                gameManager.add(game);
                System.out.println("\nAdding game:\n\t" + game + "\n");
                this.showMenu();
                break;

            case 3:
                System.out.println("Games: " + "\n-------------- ");
                if(gameManager.numberOfGames() == 0){
                    System.out.println("\tNo game to delete");
                }
                else {
                    int i = 1;
                    for (Game g : gameManager) {
                        System.out.println(i + ". " + g);
                        i++;
                    }

                    System.out.println("Which game to delete (0 for none)?");
                    int gameToDelete = in.nextInt();

                    if (gameToDelete == 0) {
                        showMenu();
                        break;
                    }
                    else {
                        repeat = true;
                        while (repeat) {
                            try {
                                gameManager.delete(gameToDelete);
                                repeat = false;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid value.\n" + e.getMessage()
                                        + "Which game to delete (0 for none)?");
                                gameToDelete = in.nextInt();
                            }
                        }
                        System.out.println("Game deleted.\n");
                    }
                }
                this.showMenu();
                break;

            case 0:
                System.out.println("DONE!");
                break;

            default:
                this.showMenu();
        }

    }

}
