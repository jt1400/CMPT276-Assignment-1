/*
  The TextUI class is used to interact with the user by printing to the screen and reading from
  the keyboard.
  TextUI can show 4 menu choices, list game, add new game, delete game and exit.
  User can choose a menu by entering a number.
  Each time the user enters a number, if the number is out of range for that value then display
  a message stating what values are allowed and re-ask for the value. Applies to menu
  choices and entering values.
 */

package com.example.gamescorecalculator.ui;

import com.example.gamescorecalculator.model.Game;
import com.example.gamescorecalculator.model.GameManager;
import com.example.gamescorecalculator.model.PlayerScore;

import java.util.Scanner;


public class TextUI {
    private final GameManager gameManager;
    private final Scanner in = new Scanner(System.in);// Read from keyboard


    public TextUI(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    // This method print all the games in ascending order of the time it was created
    public void listGame(){
        int i = 1;
        for(Game game : gameManager) {
            System.out.println(i + ". " + game);
            i++;
        }
    }

    // This method shows the menu choices to user and handle the choices
    public void showMenu() {
        System.out.println("Menu: \n-------------- " +
                "\n1. List games " +
                "\n2. New game " +
                "\n3. Delete game " +
                "\n0. Exit " +
                "\n:");

        int menuChoice = in.nextInt();

        // If the user enter an invalid number for the menu choice,
        // an error message will be shown and the user will be asked to enter another number
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

        switch(menuChoice){
            // User choose List games
            case 1:
                System.out.println("Games: " + "\n-------------- ");

                // If no game has been created
                if(gameManager.getNumberOfGames() == 0){
                    System.out.println("\tNo games");
                }
                else{
                    listGame();
                }

                System.out.println("\n");
                this.showMenu();
                break;

            // User choose New game
            case 2:
                // Create a Game
                Game game = new Game();

                System.out.println("How many players?");
                int numberOfPlayers = in.nextInt();

                // If the user enter an invalid number for the number of player,
                // an IllegalArgumentException will be thrown from the PlayerScore class
                // and the user will be asked to enter another number
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

                // Create a PlayerScore object to represent each player
                for(int i = 1; i <= numberOfPlayers; i++) {
                    PlayerScore player = new PlayerScore();

                    System.out.println("Player " + i + "\n\tHow many cards?");
                    int numberOfCards = in.nextInt();

                    // If the user enter an invalid number for the number of cards,
                    // an IllegalArgumentException will be thrown from the PlayerScore class
                    // and the user will be asked to enter another number
                    repeat = true;
                    while (repeat) {
                        try {
                            player.setNumberOfCards(numberOfCards);
                            repeat = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid value. \n" + e.getMessage()
                                    + "\n\tHow many cards?");
                            numberOfCards = in.nextInt();
                        }
                    }

                    // If the number of cards is 0, user does not need to enter the sum of cards
                    // and number of wager cards since they will be 0
                    if (numberOfCards == 0) {
                        game.addPlayer(player);
                        continue;
                    }

                    System.out.println("\tSum of Cards?");
                    int sumOfCards = in.nextInt();

                    // If the user enter an invalid number for the sum of cards,
                    // an IllegalArgumentException will be thrown from the PlayerScore class
                    // and the user will be asked to enter another number
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

                    // If the user enter an invalid number for the number of wager cards,
                    // an IllegalArgumentException will be thrown from the PlayerScore class
                    // and the user will be asked to enter another number
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

                // After entering information about the game, game is added to gameManager
                gameManager.add(game);
                System.out.println("\nAdding game:\n\t" + game + "\n");

                this.showMenu();
                break;

            // User choose Delete game
            case 3:
                System.out.println("Games: " + "\n-------------- ");

                if(gameManager.getNumberOfGames() == 0){
                    System.out.println("\tNo game to delete");
                }
                else {
                    listGame();

                    System.out.println("Which game to delete (0 for none)?");
                    int gameToDelete = in.nextInt();

                    // User choose to delete nothing
                    if (gameToDelete == 0) {
                        showMenu();
                        break;
                    }
                    else {
                        // If the user enter an invalid number of game to delete,
                        // an IllegalArgumentException will be thrown from the GameManager class
                        // and the user will be asked to enter another number
                        repeat = true;
                        while (repeat) {
                            try {
                                gameManager.delete(gameToDelete);
                                System.out.println("Game deleted.\n");
                                repeat = false;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid value.\n" + e.getMessage()
                                        + "\nWhich game to delete (0 for none)?");
                                gameToDelete = in.nextInt();
                            }
                        }
                    }
                }
                this.showMenu();
                break;

            // User choose exit
            case 0:
                System.out.println("DONE!");
                break;

            default:
                this.showMenu();
                break;
        }

    }

}
