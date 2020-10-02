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

        System.out.println("Welcome to the Pet Store!");
        System.out.println("What Animal would you like to buy?");
        System.out.println("1. Sheep");
        System.out.println("2. Dog");
        input = scanner.next();

        if(input.equals("1")){
            System.out.println("What are you going to call your sheep?");
            input = scanner.next();
            System.out.println("What gender?");
            input2 = scanner.next();
            animals.add(new Sheep(input,input2));
        }


    }

}
