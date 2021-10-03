package com.sofka.gameQuestionApp.model;

public class Point extends Award {

    public Point(int amount) {
        super(amount);
    }



    @Override
    public String getType() {
        return "Point";
    }
}
