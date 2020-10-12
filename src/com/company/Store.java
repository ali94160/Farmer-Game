package com.company;
import java.util.*;
public class Store {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String CYAN_BRIGHT = "\033[0;96m";

    static Scanner scanner = new Scanner(System.in);
    static String input = "";
    static String input2 = "";

    public static void buyAnimal(Player p){

        do {
            System.out.println("---------------[PET STORE]--------------");
            System.out.println("Balance: " + "$" + p.money);
            System.out.println("[" + p.name + "]" + " What Animal would you like to buy?");
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
                p.money = (p.money - 2000);
                System.out.print("Name your Sheep: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2) {
                    case "1":
                        input2 = (String) "male";
                        p.animals.add(new Sheep(input, input2));
                        break;
                    case "2":
                        input2 = (String) "female";
                        p.animals.add(new Sheep(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Sheep" + " " + "(" + input2 + ")" + " for $2000 \n");
            }
            if (input.equals("2")) {
                p.money = (p.money - 2000);
                System.out.print("Name your Dog: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2) {
                    case "1":
                        input2 = (String) "male";
                        p.animals.add(new Dog(input, input2));
                        break;
                    case "2":
                        input2 = (String) "female";
                        p.animals.add(new Dog(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Dog" + " " + "(" + input2 + ")" + " for $2000 \n");
            }


            if (input.equals("3")) {
                p.money = (p.money - 2000);
                System.out.print("Name your Cow: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2) {
                    case "1":
                        input2 = (String) "male";
                        p.animals.add(new Cow(input, input2));
                        break;
                    case "2":
                        input2 = (String) "female";
                        p.animals.add(new Cow(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Cow" + " " + "(" + input2 + ")" + " for $2000 \n");
            }


            if (input.equals("4")) {
                p.money = (p.money - 2000);
                System.out.println("Name your Cat: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2) {
                    case "1":
                        input2 = (String) "male";
                        p.animals.add(new Cat(input, input2));
                        break;
                    case "2":
                        input2 = (String) "female";
                        p.animals.add(new Cat(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + ANSI_GREEN+
                    "You've purchased a Cat" + " " + "(" + input2 + ")" + " for $2000 \n"+ ANSI_RESET);
            }


            if (input.equals("5")) {
                p.money = (p.money - 2000);
                System.out.println("Name your Rabbit: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                input2 = scanner.next();
                switch (input2) {
                    case "1":
                        input2 = (String) "male";
                        p.animals.add(new Rabbit(input, input2));
                        break;
                    case "2":
                        input2 = (String) "female";
                        p.animals.add(new Rabbit(input, input2));
                        break;
                }
                System.out.println("\n".repeat(25));
                System.out.println("-".repeat(41) + "\nYou've Purchased a Rabbit" + " " + "(" + input2 + ")" + " for $2000 \n");
            }


        } while (!input.equals("6"));
        System.out.println("\n".repeat(25));
        return;
    }

    public static void food(Player p){
        do {
            System.out.println("\n");
            System.out.println("---------------[FOOD STORE]--------------");
            System.out.println("Balance: " + "$" + p.money);
            System.out.println("[" + p.name + "]" + " What Animal would you like to buy?");
            System.out.println("-".repeat(41));
            System.out.println("1. Apples  | cost: $200 |");
            System.out.println("2. Carrots | cost: $200 |");
            System.out.println("3. Grass   | cost: $200 |");
            System.out.println("-".repeat(41));
            System.out.println("6. EXIT THE SHOP");
            input = scanner.next();
            System.out.println("\n".repeat(25));

            if (input.equals("1")) {
                System.out.println("You've picked Apples...");
                System.out.println("How many KG? (minimum 1 kg)");
                input2 = scanner.next();
                p.money -= Integer.parseInt(input2) * 200;
                checkFood("Apple",p);
                System.out.println("\n".repeat(25));
                System.out.println("You bought " + input2 + "kg apples...");
                p.food.add(new Apples("Apple", (Integer.parseInt(input2)), 200));
            }

            if (input.equals("2")){
                System.out.println("You've picked Carrots...");
                System.out.println("How many KG? (minimum 1 kg)");
                input2 = scanner.next();
                p.money = p.money - Integer.parseInt(input2) * 200;
                checkFood("Carrot",p);
                System.out.println("\n".repeat(25));
                System.out.println("You bought " + input2 + "kg carrots...");
                p.food.add(new Carrots("Carrot",(Integer.parseInt(input2)),200));
            }

            if(input.equals("3")){
                System.out.println("You've picked Grass...");
                System.out.println("How many KG? (minimum 1 kg)");
                input2 = scanner.next();
                p.money = p.money - Integer.parseInt(input2) * 200;
                checkFood("Grass", p);
                System.out.println("\n".repeat(25));
                System.out.println("You bought " + input2 + "kg grass...");
                p.food.add(new Grass("Grass",(Integer.parseInt(input2)),200));
            }
        } while (!input.equals("6"));
        return;

    }


    public static void checkFood(String type, Player p) {
        int check = 0;
        int add = 0;
        for (int i = 0; i < p.food.size(); i++) {
            if (p.food.get(i).name.equals(type)) {
                check++;
            }
            if (check == 2) {
                add = p.food.get(i).kilos;
                p.food.remove(i);
            }
        }
        if(check == 2) {
            for (int i = 0; i < p.food.size(); i++) {
                if (p.food.get(i).name.equals(type)) {
                    p.food.get(i).kilos += add;
                }
            }
        }
    }
}
