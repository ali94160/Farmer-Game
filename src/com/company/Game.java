package com.company;
import java.util.*;
public class Game {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int roundInput;
    int playerInput;
    public static int healthPoints;
    String playerName;
    ArrayList<Player> players = new ArrayList<>();

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
            for(int j = 0; j < players.size(); j++){
                roundInput++;
                System.out.println("\n".repeat(25));
                System.out.println("Round: " + (i + 1));
                printMenu(players.get(j));
                System.out.println("_".repeat(30));
                System.out.println("1. Buy Animal");
                System.out.println("2. Sell Animal");
                System.out.println("3. Buy Food");
                System.out.println("4. Feed Animals");
                System.out.println("5. Make Animals");
                System.out.println("_".repeat(30));

                playerInput = scanner.nextInt();

                switch (playerInput){
                    case 1:
                        System.out.println("\n".repeat(25));
                        players.get(j).showAnimalsInStore();
                        break;
                    case 2:
                        System.out.println("\n".repeat(25));
                        players.get(j).sellAnimals(players.get(j));
                        break;

                }

            }
            healthLoss();
        }


    }


    public void printMenu(Player p){

                System.out.println("[" + p.name + "] " + "it's your turn:");
                System.out.println("-".repeat(30));
                System.out.println("Your balance: " + "$" + p.money);
                System.out.println("-".repeat(30));
                System.out.println("Your animals:");
                for(Animal a : p.animals){
                    System.out.println("(" + a.getClass().getSimpleName() + ")" + " " + a.name + "  "
                            + "(" + a.gender + ")" + "  " + a.healthPoints + "HP");
                }

    }


    public void healthLoss(){
       for(int i = 0; i < players.size(); i++){
            for(int j = 0; j < players.get(i).animals.size(); j++){
                players.get(i).animals.get(j).healthPoints -=  1 + random.nextInt(30);
            }
        }
    }

}
