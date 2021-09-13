package com.example.gamescorecalculator;


import com.example.gamescorecalculator.model.GameManager;
import com.example.gamescorecalculator.ui.TextUI;

public class Main {
    public static void main(String[] args) {
        GameManager manager = new GameManager();
        TextUI ui = new TextUI(manager);
        ui.showMenu();

    }
}