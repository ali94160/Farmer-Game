package com.company;
import java.util.*;
public class Game {

    // Colors for output
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String CYAN_BRIGHT = "\033[0;96m";
    public static final String RESET = "\033[0m";


    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    static int roundInput;
    int playerInput;
    String playerName;
    ArrayList<Player> players = new ArrayList<>();

    public Game() {
        System.out.println("-------------------------------------");
        System.out.println("===========| FARMER GAME |===========");
        System.out.println("------------------------------------- \n");

        System.out.println("Welcome to Farmer Game!\nPlease choose between 5-30 rounds:");
        while (true) {
            try {
                roundInput = scanner.nextInt();
                if (roundInput >= 5 && roundInput <= 30) {
                    break;
                }
              System.out.println("Must be between 5-30... Try again: ");

            } catch (Exception e) {
                System.out.println("Must be between 5-30... Try again: ");
                scanner.next();
            }

        }

        while (true) {
            System.out.println("How many players?");
            try {
                playerInput = scanner.nextInt();
                if (playerInput >= 1 && playerInput <= 4) {
                    break;
                }
                System.out.println("Must be between 1-4 players... Try again: ");
            } catch (Exception e) {
                System.out.println("Must be between 1-4 players... Try again: ");
                scanner.next();
            }
        }

            for (int i = 0; i < playerInput; i++) {
            System.out.println("Player " + (i + 1) +
                    ", Enter your name:");
            playerName = scanner.next();
            players.add(new Player(playerName));
        }
            System.out.println("\n".repeat(20));
            mainMenu();

    }

    public void mainMenu() {
        for (int i = 0; i < roundInput; i++) {
            for (int j = 0; j < players.size(); j++) {
                players.get(j).deadAnimal();
                checkPlayerBalanceAndAnimals(players.get(j));
                players.get(j).gotSick(players.get(j));

                boolean endTurn = false;
                while (!endTurn) {
                    System.out.println("\n".repeat(2));
                    System.out.println(BLUE_BOLD + "Round: " + (i + 1) + RESET);
                    printMenu(players.get(j));
                    System.out.println("_".repeat(30));
                    System.out.println("1. Buy Animal");
                    System.out.println("2. Sell Animal");
                    System.out.println("3. Buy Food");
                    System.out.println("4. Feed Animals");
                    System.out.println("5. Mate Animals");
                    System.out.println("_".repeat(30));

                    while (true) {
                        try {
                            playerInput = scanner.nextInt();
                            if (playerInput >= 1 && playerInput <= 5) {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                            scanner.next();
                        }
                    }
                    switch (playerInput) {
                        case 1:
                            if (players.get(j).money < 1000) {
                                System.out.println("\n".repeat(25));
                                System.out.println(CYAN_BRIGHT + "[Game]:" + RESET + "You don't have enough money");
                                endTurn = false;
                                break;
                            }
                            System.out.println("\n".repeat(28));
                            players.get(j).showAnimalsInStore();
                            endTurn = true;
                                break;

                        case 2:
                            if (players.get(j).animals.size() <= 0) {
                                System.out.println("\n".repeat(20));
                                System.out.println(CYAN_BRIGHT + "[Game]:" + RESET + " You don't have any animals.");
                                endTurn = false;
                                break;
                            } else if (players.get(j).animals.size() >= 1) {
                                System.out.println("\n".repeat(28));
                                players.get(j).sellAnimals(players.get(j));
                                endTurn = true;
                            }   break;

                        case 3:
                            if(players.get(j).money <= 0){
                                System.out.println(CYAN_BRIGHT + "[Game]:" + RESET + " You don't have enough money for that.");
                                endTurn = false;
                            } else {
                                System.out.println("\n".repeat(28));
                                players.get(j).buyFood();
                                endTurn = true;
                            } break;

                        case 4:
                            if (players.get(j).animals.size() <= 0) {
                                System.out.println("\n".repeat(25));
                                System.out.println(CYAN_BRIGHT + "[Game]:" + RESET + " You don't have any animals.");
                                endTurn = false;
                                break;
                            } else if (players.get(j).food.size() == 0) {
                                System.out.println("\n".repeat(25));
                                System.out.println("You're out of food supplies.");
                                endTurn = false;
                                break;
                            } else {
                                System.out.println("\n".repeat(28));
                                players.get(j).feedAnimal(players.get(j));
                                endTurn = true;
                            }   break;


                        case 5:
                            int male = 0;
                            int female = 0;
                            int co = 0;
                            if (players.get(j).animals.size() >= 2) {
                                for (int n = 0; n < players.get(j).animals.size(); n++) {
                                    for (int k = 0; k < players.get(j).animals.size(); k++) {
                                        if (players.get(j).animals.get(n).getClass().getSimpleName().equals(players.get(j).animals.get(k).getClass().getSimpleName())) {
                                            co++;
                                            if(players.get(j).animals.get(n).gender.equals("male")){
                                                male++;
                                            }
                                            if(players.get(j).animals.get(n).gender.equals("female")){
                                                female++;
                                            }
                                        }
                                    }
                                }
                            }
                            if(male > 0 && female > 0 && co > 0){
                                players.get(j).mateAnimals(players.get(j));
                                endTurn = true;
                            } else if(players.get(j).animals.size() < 2){
                                System.out.println("\n".repeat(20));
                                System.out.println(CYAN_BRIGHT + "[Game]: " + RESET + "You need at least 2 animals.");
                                endTurn = false;
                                break;
                            } else {
                                System.out.println("\n".repeat(20));
                                System.out.println(CYAN_BRIGHT + "[Game]: " + RESET + "You need: (male) & (female).");
                                endTurn = false;
                                break;
                            }
                    }
                }
            }
            healthLoss();
        }

        andTheWinnerIs();
    }


    public void printMenu(Player p) {

        System.out.println("[ " + BLUE_BOLD + p.name + RESET + " ] it's your turn:");
        System.out.println("-".repeat(30));
        System.out.println("Your balance: " + "$" + p.money);
        System.out.println("-".repeat(30));
        System.out.println("Your animals:");
        for (Animal a : p.animals) {

            System.out.println("(" + a.getClass().getSimpleName() + ")" + " " + a.name + "  "
                    + "(" + a.gender + ")" + "  " + a.healthPoints + "HP");
        }
        System.out.println("-".repeat(30));
        System.out.println("Your Food:");
        for (int i = 0; i < p.food.size(); i++) {

                if (p.food.get((i)).kilos == 0) {
                    p.food.remove(p.food.get(i));
                    return;
                }
                System.out.println(p.food.get(i).name + " " + p.food.get(i).kilos + "kg");
        }
    }


    public void healthLoss() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.get(i).animals.size(); j++) {
                players.get(i).animals.get(j).healthPoints -= 10 + random.nextInt(21);
            }
        }
    }

    public void andTheWinnerIs(){


        for(int i = 0; i < players.size(); i++){
            for(int j = 0; j < players.get(i).animals.size(); j++){
                players.get(i).sellAllAnimals(players.get(i).animals.get(j));

                }
            }
        Player winner = players.get(0);
        Player secondPlace = players.get(0);
        for(int i = 0; i < players.size(); i++){
            for(int j = 0; j < players.size(); j++){
                if(players.get(i).money > players.get(j).money){
                    winner = players.get(i);
                    secondPlace = players.get(j);
                }
            }
        }
        System.out.println(ANSI_GREEN + "Winner Winner Chicken Dinner! " + RESET + CYAN_BRIGHT + winner.name + RESET + "! " +
                "Your total balance is: $" +ANSI_YELLOW + winner.money + RESET);

        System.out.println("Second place is: " + CYAN_BRIGHT + secondPlace.name + RESET + " " +
                "your total balance is: $" + ANSI_YELLOW + secondPlace.money + RESET);
        System.exit(0);
        }

        public void checkPlayerBalanceAndAnimals(Player p){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).money < 40 && players.get(i).animals.size() <= 0) {
                System.out.println("Player " + players.get(i).name + " has is out of the game.");
                players.remove(i);

                if(players.size() <= 1){
                    andTheWinnerIs();
                } return;

            }
            }
        }
    }


