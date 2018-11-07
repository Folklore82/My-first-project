package com.company;

import java.util.Random;

public class Die {
    private int nrOfSides;
    private int dieValue;
    private static Random randomNumber = new Random();

    public Die(int nrOfSides){
        this.nrOfSides = nrOfSides;
    }

    public int getNrOfSides() {
        return nrOfSides;
    }

    public int getDieValue() {
        return dieValue;
    }

    public void roll(){
        dieValue = randomNumber.nextInt(nrOfSides)+1;
    }
}
