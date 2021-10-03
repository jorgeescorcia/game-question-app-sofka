package com.sofka.gameQuestionApp.model;

public abstract class Award {
    private Integer quantity;

    public Award(int amount) {
        this.quantity = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public abstract String getType();
}
