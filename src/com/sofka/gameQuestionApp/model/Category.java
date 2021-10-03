package com.sofka.gameQuestionApp.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Question> availableQuestions;

    public Category (String name){
        this.name = name;
    }

    public Category(String categoryName, ArrayList<Question> questions) {
        this.name = categoryName;
        this.availableQuestions = questions;
    }


    public List<Question> getAvailableQuestions() {
        return availableQuestions;
    }

    public void setAvailableQuestions(List<Question> availableQuestions) {
        this.availableQuestions = availableQuestions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
