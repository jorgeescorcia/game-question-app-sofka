package com.sofka.gameQuestionApp.model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Round {
    private Award award ;
    private Category category;
    private Question randomQuestion;
    private Integer minimumQuestionsAllowed;
    private Integer maximumQuestionsAllowed;
    private Boolean wasCorrectAnswered;
    private Option chooseOption;

    public Round(){

    }

    public Question getRandomQuestion() {
        if(randomQuestion==null) {
            calculateRandomQuestion();
        }
        return randomQuestion;
    }

    private void calculateRandomQuestion(){
        Question randomQuestionResponse =null;
        List<Question> availableQuestions= category.getAvailableQuestions();
        //apply random
        int randomNum = ThreadLocalRandom.current()
                .nextInt(this.minimumQuestionsAllowed, this.maximumQuestionsAllowed + 1);
        setRandomQuestion( randomQuestionResponse );
    }

    public void requestToChooseToPlayer(Player player){
        System.out.println( randomQuestion.getDescription() ) ;
        chooseOption = player.chooseOption( randomQuestion.getOptions() );
    }

    public Boolean isCorrectAnswer(){
        Integer correctOptionPosition = randomQuestion.getCorrectOptionPosition();
        Option correctOption = randomQuestion.getOptions().get(correctOptionPosition);
        if(correctOption.equals(chooseOption)){
            setWasCorrectAnswered(true);
        } else{
            setWasCorrectAnswered(false);
        }
        return wasCorrectAnswered;
    }


    public void setRandomQuestion(Question randomQuestion) {
        this.randomQuestion = randomQuestion;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }


    public Integer getMinimumQuestionsAllowed() {
        return minimumQuestionsAllowed;
    }

    public void setMinimumQuestionsAllowed(Integer minimumQuestionsAllowed) {
        this.minimumQuestionsAllowed = minimumQuestionsAllowed;
    }

    public Integer getMaximumQuestionsAllowed() {
        return maximumQuestionsAllowed;
    }

    public void setMaximumQuestionsAllowed(Integer maximumQuestionsAllowed) {
        this.maximumQuestionsAllowed = maximumQuestionsAllowed;
    }

    public Boolean getWasCorrectAnswered() {
        return wasCorrectAnswered;
    }

    public void setWasCorrectAnswered(Boolean wasCorrectAnswered) {
        this.wasCorrectAnswered = wasCorrectAnswered;
    }

    public Option getChooseOption() {
        return chooseOption;
    }

    public void setChooseOption(Option chooseOption) {
        this.chooseOption = chooseOption;
    }

}