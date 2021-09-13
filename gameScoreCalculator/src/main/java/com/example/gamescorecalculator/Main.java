package com.example.gamescorecalculator;


public class Main {
    public static void main(String[] args) {
        GameManager manager = new GameManager();
        TextUI ui = new TextUI(manager);
        ui.showMenu();

    }
}