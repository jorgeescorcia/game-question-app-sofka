package com.sofka.gameQuestionApp.model;

import java.util.List;

public class Category {
    private String name;
    private List<Question> questionsAvailable;


    public List<Question> getAvailableQuestions() {
        return questionsAvailable;
    }

    public void setQuestionsAvailable(List<Question> questionsAvailable) {
        this.questionsAvailable = questionsAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
