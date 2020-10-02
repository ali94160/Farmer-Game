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

        System.out.println("[PET STORE]");
        System.out.println("What Animal would you like to buy?");
        System.out.println("1. Sheep | cost: $2000 |");
        System.out.println("2. Dog   | cost: $2000 |");
        System.out.println("3. Cow   | cost: $2000 |");
        input = scanner.next();

        if(input.equals("1")){
            money = (money - 2000);
            System.out.print("Name your Sheep: ");
            input = scanner.next();
            System.out.print("What gender? (male/female): ");
            input2 = scanner.next();
            animals.add(new Sheep(input,input2));
        }
        if(input.equals("2")){
            money = (money - 2000);
            System.out.print("Name your Dog: ");
            input = scanner.next();
            System.out.print("What gender? (male/female): ");
            input2 = scanner.next();
            animals.add(new Dog(input,input2));
        }

        if(input.equals("3")){
            money = (money - 2000);
            System.out.print("Name your Cow: ");
            input = scanner.next();
            System.out.print("What gender? (male/female): ");
            input2 = scanner.next();
            animals.add(new Cow(input,input2));
        }


    }

}
