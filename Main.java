package com.company;


import java.util.ArrayList;
import java.util.Scanner;

// Här lägger jag in en kommentar för att testa git
public class Main {

    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<>();
        players = initialize();
        int turns = 1;
        while(turns <= 5){
            System.out.println("\n"+"Round "+turns);
            takeTurn(players);
            turns++;
        }
        players = getWinners(players);
        for(int i=0; i<players.size(); i++){
            System.out.println("Winner: "+players.get(i).getName());
        }




    }
    private static ArrayList<Player> initialize(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("Enter nr of players: ");
        int nrOfPlayers = sc.nextInt();
        System.out.println("Enter nr of dice: ");
        int nrOfDice = sc.nextInt();
        System.out.println("Enter nr of sides on each dice: ");
        int nrOfSides = sc.nextInt();


        for(int i=0; i<nrOfPlayers; i++){
            System.out.println("Enter name of player " +(i+1));
            String name = sc.next();
            players.add(new Player(name));
            for(int j=0; j<nrOfDice;j++){
                players.get(i).addDie(nrOfSides);
            }

        }
        return players;

    }
    private static void takeTurn(ArrayList<Player> players){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<players.size(); i++){
            System.out.println(players.get(i).getName()+" guess sum of dice: ");
            players.get(i).rollDice();
            int guessedSum = sc.nextInt();
            if(guessedSum == players.get(i).getDieValue()){
                System.out.println("Correct!");
                players.get(i).increaseScore();

            }
            else{
                System.out.println("Wrong, correct number: "+players.get(i).getDieValue());
            }
        }
        for(int j=0; j<players.size(); j++){
            System.out.println(players.get(j).getName()+" score = "+players.get(j).getPoints());
        }
    }
    private static ArrayList<Player> getWinners(ArrayList<Player> players){
        int winningScore = 0;
        ArrayList<Player> winners = new ArrayList<>();
        for(int i =0; i<players.size(); i++){
            if(players.get(i).getPoints() > winningScore){
                winningScore = players.get(i).getPoints();
            }
        }
        for(int i =0; i<players.size(); i++){
            if(players.get(i).getPoints() == winningScore){
                winners.add(players.get(i));
            }
        }
        return winners;

    }


}
