package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private int points;
    private ArrayList<Die> diceArray = new ArrayList<Die>();

    public Player(String name){
        this.points = 0;
        this.name = name;
        this.diceArray = diceArray;
    }

    public void addDie(int sides){
        Die die = new Die(sides);
        diceArray.add(die);

    }
    public int getDieValue(){
        int sum = 0;
        for(int i=0;i<diceArray.size(); i++){
            sum = sum + diceArray.get(i).getDieValue();
        }
        return sum;
    }

    public void rollDice(){
        for(int i=0; i<diceArray.size();i++){
            diceArray.get(i).roll();
        }
    }
    public void increaseScore(){
        points++;
    }


    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }


}
