package com.company;
import java.util.*;
public class Game {

    Scanner scanner = new Scanner(System.in);
    int roundInput;
    int playerInput;
    String playerName;
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Animal> animals = new ArrayList<Animal>();

    public Game() {

        System.out.println("How many rounds would you like to play?");
        roundInput = scanner.nextInt();
        System.out.println("How many players?");
        playerInput = scanner.nextInt();

        for (int i = 0; i < playerInput; i++) {
            System.out.println("Player " + (i + 1) +
                    ", Enter your name:");
            playerName = scanner.next();
            players.add(new Player(playerName));
        }

        mainMenu();
    }

    public void mainMenu() {
        for(int i = 0; i < roundInput; i++){
            for(int j = 0; j < playerInput; j++){
                printMenu(players.get(j));

                System.out.println("_".repeat(10));
                System.out.println("1. Buy Animal");
                System.out.println("2. Sell Animal");
                System.out.println("3. Buy Food");
                System.out.println("4. Feed Animals");
                System.out.println("5. Make Animals");

            }
        }


    }


    public void printMenu(Player p){

                System.out.println(p.name + " it's your turn:");
                System.out.println("-".repeat(10));
                System.out.println("Your balance: " + p.money);
                System.out.println("-".repeat(10));
                System.out.println("Your animals:");
                for(Animal a : animals){
                    if(a == null){
                        System.out.println("You dont have any animals yet");
                    }else{
                        System.out.println(a.name + " " + a.gender + " " + a.healthPoints);
                    }
                }

    }


}
