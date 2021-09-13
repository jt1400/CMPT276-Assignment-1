package com.example.gamescorecalculator.ui;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TextUI {

    private final GameManager gameManager;
    private Scanner in = new Scanner(System.in);// Read from keyboard


    public TextUI(GameManager gameManager) {
        this.gameManager = gameManager;
    }


    public void showMenu() {
        // BEGIN SAMPLE USING SCREEN AND KEYBOARD:
        // (remove this: it's just to show you how to access the screen and keyboard!)
        System.out.println("Menu: \n-------------- " +
                "\n1. List games " +
                "\n2. New game " +
                "\n3.Delete game " +
                "\n0. Exit " +
                "\n:");
        int menuChoice = in.nextInt();

        System.out.println();
        System.out.print("Prompt on same line: ");
        int favNum = in.nextInt();

        System.out.println("Printing " + count + " times!");
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": Hello world; your favourite number is " + favNum);
        }

        // END SAMPLE

        // DO NOT HARD-CODE YOUR INTERFACE; DON'T REPEAT YOUR CODE!
    }

}
