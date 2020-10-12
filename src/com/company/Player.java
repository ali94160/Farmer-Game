package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String CYAN_BRIGHT = "\033[0;96m";

    Scanner scanner = new Scanner(System.in);
    String input3 = "";
    String input = "";
    String input2 = "";
    public int money;
    public String name;
    public ArrayList<Animal> animals = new ArrayList<Animal>();
    ArrayList<Food> food = new ArrayList<Food>();

    public Player(String name) {
        this.name = name;
        this.money = 10000;
    }

    public void showAnimalsInStore() {
        Store.buyAnimal(this);
    }

    public void sellAnimals(Player p) {
        while (true) {
            System.out.println("What Animals would you like to sell:");
            int optionCounter = 1;
            System.out.println("0. EXIT");
            for (Animal a : p.animals) {
                System.out.println(optionCounter + "." + "(" + a.getClass().getSimpleName() + ")" + " " + a.name + "  "
                        + "(" + a.gender + ")" + "  " + a.healthPoints + "HP" + " -> Sell for: $" + (a.price * a.healthPoints) / 100);
                optionCounter++;
            }
            input = scanner.next();

            if (input.equals("0")) {
                return;
            }
            sellAnimal(animals.get(Integer.parseInt(input) - 1));
            animals.remove(Integer.parseInt(input) - 1);
        }
    }


    public void buyFood() {
        if(money < 200){
            System.out.println("\n".replace("\n",""));
            System.out.println("You don't have enough money.");
            return;
        }
            Store.food(this);
    }

    public void sellAnimal(Animal a){
       int profit = (a.healthPoints * a.price) / 100;
       money += profit;
    }

    public  void deadAnimal(){
        System.out.println("\n".repeat(15));
        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).healthPoints <= 0){
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + animals.get(i).name + ANSI_RED +" has died..." + ANSI_RESET);
                animals.remove(i);
            }

        }

    }



    public void feedAnimal(Player p){
        while(true){
            System.out.println("\n".repeat(2));
        System.out.println("[" + p.name + "]" + " What Animal would you like to feed?");
            System.out.println("-".repeat(45));
            int optionCounter = 1;
            for (Animal a : p.animals) {
                System.out.println(optionCounter + "." + "(" + a.getClass().getSimpleName() + ")" + " " + a.name + "  "
                        + "(" + a.gender + ")" + "  " + a.healthPoints);
                optionCounter++;
         }
            System.out.println("-".repeat(45));
            System.out.println("0. EXIT");

            input = scanner.next();

            if (input.equals("0")) {
                return;
            }

            System.out.println("What food?");
            int optionCounter2 = 1;
            for(int i = 0; i < p.food.size();i++) {
                System.out.println(optionCounter2 + "." + p.food.get(i).name + " " + p.food.get(i).kilos + "kg");
                optionCounter2++;
            }

                input3 = scanner.next();
                    System.out.println("How many Kg?");
                input2 = scanner.next();
            System.out.println("\n".repeat(25));


                feedTheAnimal(animals.get(Integer.parseInt(input)-1));
                p.food.get(Integer.parseInt(input3)-1).kilos -= Integer.parseInt(input2);
            System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +
                    animals.get(Integer.parseInt(input)-1).name + " has gained " + "+ " + (Integer.parseInt(input2) * 10) + "HP");


        }
    }

    public void feedTheAnimal(Animal a){
       a.healthPoints += 10 * Integer.parseInt(input2);
    }

}





