package com.sofka.gameQuestionApp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Match {
    private Integer matchId;
    private Player player;
    private List<Award> acumulatedAwards;
    private boolean isFinished;
    private boolean isWhitdrawn;
    private boolean isWinner;
    private boolean isLost;
    private List<Round> rounds;
    private List<Category> categories;
    private Integer currentRoundId;
    private Integer latestRoundId;
    private Scanner scanner;


    public void setGameConfiguration() {
        scanner = new Scanner( System.in);
        // solicitar numer de preguntas totales
        System.out.println("Bienvenido!!! ");
        System.out.println("Digita a continuacion el numero de preguntas que quieres");
        Integer wantedQuestionAmount = scanner.nextInt();
        // crear categorias
        //  menu: 1. crear categoria, 2. finalizar cracion de categoria.
        categories = new ArrayList<>();
        String categoryName= "";
        Integer categoryMenuSelected= 0;
        while ( categoryMenuSelected != 2 ){
            System.out.println("Crear categoria de preguntas: ");
            System.out.println("  1. crear nueva categoria ");
            System.out.println("  2. continuar con la creacion de preguntas ");
            categoryMenuSelected = scanner.nextInt();
            if (categoryMenuSelected == 1){
                System.out.println("Escribe el nombre de la categoria");
                categoryName=  scanner.next();
                categories.add(new Category(categoryName, new ArrayList<>()));
            }
        }
        System.out.println(categories.toArray().toString());
        // solicitar preguntas : mostrar las categirias para asignarla a una de ellas

            for(Integer i=1; i<= wantedQuestionAmount;i++) {
                //mostrar en pantalla las opciones de las categorias antes de que escriban las preguntas
                System.out.println("Nueva pregunta ");
                System.out.println("- Seleccione la categoria: ");
                Integer counter = 1;
                Integer categorySelected = 0;
                Question questionToCreate = new Question() ;
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
                new Question(questionDescription);
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

        //opcional: guardar en DB
    }

    public void startGame(){

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
