package com.sofka.gameQuestionApp.model;

public class Money extends Award{

    public Money(int amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "Money";
    }
}
