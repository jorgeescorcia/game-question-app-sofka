package com.sofka.gameQuestionApp;

import com.sofka.gameQuestionApp.model.Match;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Match match = new Match();
        match.setGameConfiguration();
        System.out.println("!! configuracion completada con exito !!");
        match.startGame();
    }
}
