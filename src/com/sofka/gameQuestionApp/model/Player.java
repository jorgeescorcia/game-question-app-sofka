package com.sofka.gameQuestionApp.model;

import java.util.List;
import java.util.Scanner;

public class Player {
    private String id ;
    private String name;

    private Scanner scanner;

    public Player(){
        scanner=new Scanner(System.in);
    }

    /**
     * Request to user select one option.
     * @return
     */
    public Option chooseOption(List<Option> optionList){
        // mostrar las opciones en consola
        Option optionResponse = null;
        System.out.println("Selecciona una de las siguientes opciones: ");
        printOptionsToPlayer(optionList);
        // pedir al usuario que sleccione
        Integer optionSelectedNumber = scanner.nextInt();
        // find option in list to match number selected
        optionResponse= optionList.get( optionSelectedNumber - 1 );
        return optionResponse;
    }

    private void printOptionsToPlayer(List<Option> optionList) {
        //1 . option 1
        //2. option2
        Integer optionNumber=1 ;
        for ( Option option : optionList ) {
            System.out.println( optionNumber + ". " + option.getDescription() );
            optionNumber++;
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
