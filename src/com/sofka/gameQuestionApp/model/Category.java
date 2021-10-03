package com.sofka.gameQuestionApp.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Question> availableQuestions;
    private Integer level ;


    public Category(String categoryName, Integer level ,  ArrayList<Question> questions) {
        this.name = categoryName;
        this.availableQuestions = questions;
        this.level = level;
    }

    public Category(Category randomCategory) {
        this.name = randomCategory.getName();
        this.level = randomCategory.getLevel();
        this.availableQuestions= randomCategory.getAvailableQuestions();
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
