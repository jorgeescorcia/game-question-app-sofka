package com.sofka.gameQuestionApp.model;

import java.util.List;

public class Question {
    private String description;
    private List< Option > options;
    private Integer correctOptionPosition;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Integer getCorrectOptionPosition() {
        return correctOptionPosition;
    }

    public void setCorrectOptionPosition(Integer correctOptionPosition) {
        this.correctOptionPosition = correctOptionPosition;
    }


}
