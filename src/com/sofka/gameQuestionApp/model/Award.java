package com.sofka.gameQuestionApp.model;

public abstract class Award {
    private Integer Quantity;

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public abstract String getType();
}
