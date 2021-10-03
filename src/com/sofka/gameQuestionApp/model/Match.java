package com.sofka.gameQuestionApp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Match {
    private Integer matchId;
    private Player player;
    private List<Award> acumulatedAwards;
    private List<Award> configPosibleAwards;
    private boolean isFinished;
    private boolean isWhitdrawn;
    private boolean isWinner;
    private boolean isLost;
    private List<Round> rounds;
    private List<Category> categories;
    private Integer currentRound;
    private Integer latestRoundId;
    private Scanner scanner;


    public void setGameConfiguration() {
        scanner = new Scanner(System.in);
        // solicitar numer de preguntas totales
        System.out.println("Bienvenido!!! ");
        System.out.println("Digita a continuacion el numero de preguntas que quieres");
        Integer wantedQuestionAmount = scanner.nextInt();
        // crear categorias
        //  menu: 1. crear categoria, 2. finalizar cracion de categoria.
        categories = new ArrayList<>();
        String categoryName = "";
        Integer categoryMenuSelected = 0;
        while (categoryMenuSelected != 2) {
            System.out.println("Crear categoria de preguntas: ");
            System.out.println("  1. crear nueva categoria ");
            System.out.println("  2. continuar con la creacion de preguntas ");
            categoryMenuSelected = scanner.nextInt();
            if (categoryMenuSelected == 1) {
                scanner.nextLine();
                System.out.println("Escribe el nombre de la categoria");
                categoryName = scanner.nextLine();
                System.out.println("Digita el nivel de dificulta de 1-5 + Enter");
                Integer level = scanner.nextInt();
                categories.add(new Category(categoryName, level, new ArrayList<>()));
            }
        }
        System.out.println(categories.toArray().toString());
        // solicitar preguntas : mostrar las categirias para asignarla a una de ellas

        for (Integer i = 1; i <= wantedQuestionAmount; i++) {
            //mostrar en pantalla las opciones de las categorias antes de que escriban las preguntas
            System.out.println("Nueva pregunta ");
            System.out.println("- Seleccione la categoria: ");
            Integer counter = 1;
            Integer categorySelected = 0;
            Question questionToCreate = new Question();
            questionToCreate.setOptions(new ArrayList<>());
            for (Category category : categories) {
                System.out.println("digite el numero + Enter");
                System.out.println(counter + " " + category.getName());
                counter++;
            }
            categorySelected = scanner.nextInt();
            String questionDescription = null;
            System.out.println("Escriba la pregunta:");
            scanner.nextLine();
            questionDescription = scanner.nextLine();
            System.out.println(" !!--- questionDespcription in line 68::: " + questionDescription);
            questionToCreate = new Question(questionDescription);
            questionToCreate.setOptions(new ArrayList<>());
            //solicitar las opciones.
            Integer amountOfQuestionsAllowed = 4;
            Integer optionCounter = 0;
            for (int j = 1; j <= amountOfQuestionsAllowed; j++) {
                optionCounter++;
                Option currentOption = null;
                System.out.println("Escriba el cuerpo de la opcion de respuesta #" + optionCounter);
                String optionDescription = null;
                optionDescription = scanner.nextLine();
                currentOption = new Option(optionDescription);
                questionToCreate
                        .getOptions()
                        .add(currentOption);
            }
            //scanner.nextLine();
            System.out.println("Configura la opcion correcta.");
            optionCounter = 0;
            for (Option questionOption : questionToCreate.getOptions()) {
                optionCounter++;
                System.out.println(optionCounter + " . " + questionOption.getDescription());
            }
            System.out.println("Selecciona la opcion correcta");
            Integer correctConfiguredOptionSelected = scanner.nextInt();
            questionToCreate.setCorrectOptionPosition(correctConfiguredOptionSelected - 1);
            categories.get(categorySelected - 1)
                    .getAvailableQuestions()
                    .add(questionToCreate);
        }
        //configuracion de premios
        System.out.println("--- Seccion de Premios");
        System.out.println(" 1- Puntos");
        System.out.println(" 2- Money ");
        System.out.println(" Seleccione el tipo de premio que va a entregar");
        Integer awardType = scanner.nextInt();
        configPosibleAwards = new ArrayList<>();
        for(int k = 1; k<=5; k++){
            Award award = null;
            System.out.println("-- Ingrese la cantidad para el nivel " + k);
            Integer amount = scanner.nextInt();
            if (awardType == 1){
                award = new Point( amount );
            }else if(awardType == 2){
                award = new Money( amount );
            }
            configPosibleAwards.add( award );
            }

        System.out.println(" !!!! awards config");
        Integer currentPosibleAward = 1;
        for ( Award award : configPosibleAwards) {
            System.out.println(" -- level "+  currentPosibleAward + " amount : " + award.getQuantity());
            currentPosibleAward++;
        }

        //opcional: guardar en DB
        System.out.println("!!!! ---- !!!");
        System.out.println("!! Has configurado correctamente !!1");
        for (Category category: categories) {
            System.out.println("--Category: "+ category.getName() + " , level: "+ category.getLevel());
            for (Question question : category.getAvailableQuestions()) {
                System.out.println(" -- - Question: " + question.getDescription());
                System.out.println(" - -- -  correct option: "+ (question.getCorrectOptionPosition()+1) );
                for (Option option: question.getOptions()) {
                    System.out.println("--- - - -- Description :" + option.getDescription());
                }
            }
        }

    }

    public void startGame(){
//opcional: guardar en DB
        System.out.println("!!!! ---- !!!");
        System.out.println("!! Has configurado correctamente !!1");
        for (Category category: categories) {
            System.out.println("--Category: "+ category.getName() + " , level: "+ category.getLevel());
            for (Question question : category.getAvailableQuestions()) {
                System.out.println(" -- - Question: " + question.getDescription());
                System.out.println(" - -- -  correct option: "+ (question.getCorrectOptionPosition()+1) );
                for (Option option: question.getOptions()) {
                    System.out.println("--- - - -- Description :" + option.getDescription());
                }
            }
        }

        rounds = new ArrayList<>();
        Integer roundCounter= 1;
        for (int i = 1; i<=5; i++){
            currentRound = i;
            //elegir una categoria aleatoria segun nivel de ronda
            Category randomCategory = getRandmonCategory( i );
            Round currentRound = new Round( new Category(randomCategory) );
            currentRound.getRandomQuestion();
            currentRound.requestToChooseToPlayer(new Player());
            Boolean wasCorrectAnswered = currentRound.isCorrectAnswer();
            if(wasCorrectAnswered){
                currentRound.setAward(new Money(500_000));
                addAwardtoAcumulativeAwards( currentRound );
                //aumentar la ronda
                continue;
            }else{
                //manageLostGame();
            }
        }
        //
    }

    private void addAwardtoAcumulativeAwards(Round currentRound) {

    }

    /**
     * Select a category by level of round.
     * @return
     */
    private Category getRandmonCategory(Integer roundLevel) {
        Category randomCategory = null;
        List<Category> filteredCategoriiesBLevel = new ArrayList<>();

        for ( Category category : categories) {
            if (category.getLevel() == roundLevel)
                filteredCategoriiesBLevel.add(category);
        }

        int randomNum = ThreadLocalRandom.current()
                .nextInt(0, filteredCategoriiesBLevel.size()  ); //+1
        filteredCategoriiesBLevel.get( randomNum );
        return randomCategory;
    }

    public Round nextRound(){
        Round response = null;
        //TODO: write code ...
        return response;
    }

    public Boolean isFinalRound(){
        Boolean response = null;
        //TODO: write code ...
        return response;
    }

    public List<Award> wantLeaveGame(){
        List<Award> response = new ArrayList<>();
        //TODO: write down code ...
        return response;
    }

    public void deleteAwards(){}

    public void calculateTotalAwards(){}


}
