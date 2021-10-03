package com.sofka.gameQuestionApp.model;

public class Option {
    private String description;

    public Option(String optionDescription) {
            this.description = optionDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
