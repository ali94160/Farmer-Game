package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    String input2 = "";
    public int money;
    public String name;
    ArrayList<Animal> animals = new ArrayList<Animal>();
    ArrayList<Food> food = new ArrayList<Food>();

    public Player(String name){
        this.name = name;
        this.money = 10000;
    }

    public void showAnimalsInStore(){

        do{
            System.out.println("\n");
            System.out.println("---------------[PET STORE]--------------");
            System.out.println("Balance: " + "$" + money);
            System.out.println("[" + Player.this.name + "]" +  " What Animal would you like to buy?");
            System.out.println("-".repeat(41));
            System.out.println("1. Sheep  | cost: $2000 |");
            System.out.println("2. Dog    | cost: $2000 |");
            System.out.println("3. Cow    | cost: $2000 |");
            System.out.println("4. Cat    | cost: $2000 |");
            System.out.println("5. Rabbit | cost: $2000 |");
            System.out.println("-".repeat(41));
            System.out.println("6. EXIT THE SHOP");
            input = scanner.next();

            if (input.equals("1")) {
                money = (money - 2000);
                System.out.print("Name your Sheep: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2){
                    case "1": input2 = (String)"male";
                        animals.add(new Sheep(input, input2));
                    break;
                    case "2": input2 = (String)"female";
                        animals.add(new Sheep(input, input2));
                    break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Sheep" + " " + "(" + input2 + ")" + " for $2000 \n");
            }
            if (input.equals("2")) {
                money = (money - 2000);
                System.out.print("Name your Dog: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2){
                    case "1": input2 = (String)"male";
                        animals.add(new Dog(input, input2));
                        break;
                    case "2": input2 = (String)"female";
                        animals.add(new Dog(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Dog" + " " + "(" + input2 + ")" + " for $2000 \n");
            }


            if (input.equals("3")) {
                money = (money - 2000);
                System.out.print("Name your Cow: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2){
                    case "1": input2 = (String)"male";
                        animals.add(new Cow(input, input2));
                        break;
                    case "2": input2 = (String)"female";
                        animals.add(new Cow(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Cow" + " " + "(" + input2 + ")" + " for $2000 \n");
            }


            if (input.equals("4")) {
                money = (money - 2000);
                System.out.println("Name your Cat: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2){
                    case "1": input2 = (String)"male";
                        animals.add(new Cat(input, input2));
                        break;
                    case "2": input2 = (String)"female";
                        animals.add(new Cat(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Cat" + " " + "(" + input2 + ")" + " for $2000 \n");
            }


            if (input.equals("5")) {
                money = (money - 2000);
                System.out.println("Name your Rabbit: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2){
                    case "1": input2 = (String)"male";
                        animals.add(new Rabbit(input, input2));
                        break;
                    case "2": input2 = (String)"female";
                        animals.add(new Rabbit(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Rabbit" + " " + "(" + input2 + ")" + " for $2000 \n");
            }


            }while(!input.equals("6"));



    }

    public void sellAnimals(Player p) {
                while(true) {
                    System.out.println("What Animals would you like to sell:");
                    int optionCounter = 1;
                    System.out.println("0. EXIT");
                    for (Animal a : p.animals) {
                        System.out.println(optionCounter + "." + "(" + a.getClass().getSimpleName() + ")" + " " + a.name + "  "
                                + "(" + a.gender + ")" + "  " + a.healthPoints + "HP");
                        optionCounter++;
                    }
                    input = scanner.next();

                    if (input.equals("0")) {
                        return;
                    }
                    animals.remove(Integer.parseInt(input) - 1);
                    money += 2000;
                }
        }

        }





