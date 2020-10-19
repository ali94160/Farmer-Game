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
    private static Object Carrots;

    public static void buyAnimal(Player p){

        do {
            System.out.println("---------------[PET STORE]--------------");
            System.out.println("Balance: " + "$" + p.money);
            System.out.println("[" + p.name + "]" + " What Animal would you like to buy?");
            System.out.println("-".repeat(41));
            System.out.println("| ANIMALS | PRICE | MAX CHILD | MAX AGE |");
            System.out.println("1. Rabbit | $1000 |   5       |    5    |");
            System.out.println("2. Dog    | $2000 |   3       |    10   |");
            System.out.println("3. Cat    | $2000 |   3       |    10   |");
            System.out.println("4. Sheep  | $2500 |   2       |    12   |");
            System.out.println("5. Cow    | $3000 |   2       |    16   |");
            System.out.println("-".repeat(41));
            System.out.println("0. EXIT THE SHOP");
            input = scanner.next();

            if (input.equals("1")) {
                System.out.print("Name your Rabbit: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                try {
                    input2 = scanner.next();
                    if((Integer.parseInt(input2) == 1 || Integer.parseInt(input2) == 2)) {
                        switch (input2) {
                            case "1":
                                p.money = (p.money - 1000);
                                input2 = (String) "male";
                                p.animals.add(new Rabbit(input, input2, "Carrot"));
                                break;
                            case "2":
                                p.money = (p.money - 1000);
                                input2 = (String) "female";
                                p.animals.add(new Rabbit(input, input2, "Carrot"));
                                break;
                        }
                        System.out.println("\n".repeat(25));
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + ANSI_GREEN+
                                "You've purchased a Rabbit" + " " + "(" + input2 + ")" + " for $1000 \n"+ ANSI_RESET);
                    }
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                } catch (Exception e){
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                    buyAnimal(p);
                }
            }

            if (input.equals("2")) {
                System.out.print("Name your Dog: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                try {
                    input2 = scanner.next();
                    if((Integer.parseInt(input2) == 1 || Integer.parseInt(input2) == 2)) {
                        switch (input2) {
                            case "1":
                                p.money = (p.money - 2000);
                                input2 = (String) "male";
                                p.animals.add(new Dog(input, input2, "Apple"));
                                break;
                            case "2":
                                p.money = (p.money - 2000);
                                input2 = (String) "female";
                                p.animals.add(new Dog(input, input2, "Apple"));
                                break;
                        }
                        System.out.println("\n".repeat(25));
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + ANSI_GREEN+
                                "You've purchased a Dog" + " " + "(" + input2 + ")" + " for $2000 \n"+ ANSI_RESET);
                    }
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                } catch (Exception e){
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                    buyAnimal(p);
                }
            }


            if (input.equals("3")) {
                System.out.print("Name your Cat: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                try {
                    input2 = scanner.next();
                    if((Integer.parseInt(input2) == 1 || Integer.parseInt(input2) == 2)) {
                        switch (input2) {
                            case "1":
                                p.money = (p.money - 2000);
                                input2 = (String) "male";
                                p.animals.add(new Cat(input, input2, "Apple"));
                                break;
                            case "2":
                                p.money = (p.money - 2000);
                                input2 = (String) "female";
                                p.animals.add(new Cat(input, input2, "Apple"));
                                break;
                        }
                        System.out.println("\n".repeat(25));
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + ANSI_GREEN+
                                "You've purchased a Cat" + " " + "(" + input2 + ")" + " for $2000 \n"+ ANSI_RESET);
                    }
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                } catch (Exception e){
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                    buyAnimal(p);
                }
            }


            if (input.equals("4")) {
                System.out.print("Name your Sheep: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                try {
                    input2 = scanner.next();
                    if((Integer.parseInt(input2) == 1 || Integer.parseInt(input2) == 2)) {
                        switch (input2) {
                            case "1":
                                p.money = (p.money - 2500);
                                input2 = (String) "male";
                                p.animals.add(new Sheep(input, input2, "Grass"));
                                break;
                            case "2":
                                p.money = (p.money - 2500);
                                input2 = (String) "female";
                                p.animals.add(new Sheep(input, input2, "Grass"));
                                break;
                        }
                        System.out.println("\n".repeat(25));
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + ANSI_GREEN+
                                "You've purchased a Sheep" + " " + "(" + input2 + ")" + " for $2500 \n"+ ANSI_RESET);
                    }
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                } catch (Exception e){
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                    buyAnimal(p);
                }
            }


            if (input.equals("5")) {
                System.out.print("Name your Cow: ");
                input = scanner.next();
                System.out.print("What gender: \n 1. Male \n 2. Female \n");
                try {
                    input2 = scanner.next();
                    if((Integer.parseInt(input2) == 1 || Integer.parseInt(input2) == 2)) {
                        switch (input2) {
                            case "1":
                                p.money = (p.money - 3000);
                                input2 = (String) "male";
                                p.animals.add(new Cow(input, input2, "Grass"));
                                break;
                            case "2":
                                p.money = (p.money - 3000);
                                input2 = (String) "female";
                                p.animals.add(new Cow(input, input2, "Grass"));
                                break;
                        }
                        System.out.println("\n".repeat(25));
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + ANSI_GREEN+
                                "You've purchased a Cow" + " " + "(" + input2 + ")" + " for $3000 \n"+ ANSI_RESET);
                    }
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                } catch (Exception e){
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                    buyAnimal(p);
                }
            }


        } while (!input.equals("0"));
        System.out.println("\n".repeat(25));
    }

    public static void food(Player p){
        while (true){
            System.out.println("\n");
            System.out.println("---------------[FOOD STORE]--------------");
            System.out.println("Balance: " + "$" + p.money);
            System.out.println("[" + p.name + "]" + " What Animal would you like to buy?");
            System.out.println("-".repeat(41));
            System.out.println("1. Apples  | cost: $50 | Dog/Cat");
            System.out.println("2. Carrots | cost: $50 | Rabbit");
            System.out.println("3. Grass   | cost: $40 | Sheep/Cow");
            System.out.println("-".repeat(41));
            System.out.println("0. EXIT THE SHOP");
            input = scanner.next();
            System.out.println("\n".repeat(40));

            if (input.equals("1")) {
                System.out.println("You've picked Apples...");
                System.out.println("How many KG? (minimum 1 kg)");
                while(true) {
                    try {
                        input2 = scanner.next();
                        if(Integer.parseInt(input2) >= 0) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
                if (Integer.parseInt(input2) <= 0) {
                    System.out.println("Invalid input");
                    food(p);
                } else if (Integer.parseInt(input2) > 0) {
                    p.money -= Integer.parseInt(input2) * 50;
                    checkFood("Apple", p);
                    System.out.println("\n".repeat(25));
                    System.out.println("You bought " + input2 + "kg apples...");
                    p.food.add(new Apples("Apple", (Integer.parseInt(input2)), 50));
                }
            }

            if (input.equals("2")) {
                System.out.println("You've picked Carrots...");
                System.out.println("How many KG? (minimum 1 kg)");
                while(true) {
                    try {
                        input2 = scanner.next();
                        if(Integer.parseInt(input2) >= 0) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
                if (Integer.parseInt(input2) <= 0) {
                    System.out.println("Invalid input");
                    food(p);
                } else if (Integer.parseInt(input2) > 0) {
                    p.money -= Integer.parseInt(input2) * 50;
                    checkFood("Carrot", p);
                    System.out.println("\n".repeat(25));
                    System.out.println("You bought " + input2 + "kg carrots...");
                    p.food.add(new Apples("Carrot", (Integer.parseInt(input2)), 50));
                }
            }

            if (input.equals("3")) {
                System.out.println("You've picked Grass...");
                System.out.println("How many KG? (minimum 1 kg)");
                while(true) {
                    try {
                        input2 = scanner.next();
                        if(Integer.parseInt(input2) >= 0) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
                if (Integer.parseInt(input2) <= 0) {
                    System.out.println("Invalid input");
                    food(p);
                }
                else if(Integer.parseInt(input2) > p.money) {
                    System.out.println("Not enough money");
                    return;
                }
                    else if (Integer.parseInt(input2) > 0) {
                    p.money -= Integer.parseInt(input2) * 50;
                    checkFood("Grass", p);
                    System.out.println("\n".repeat(25));
                    System.out.println("You bought " + input2 + "kg grass...");
                    p.food.add(new Apples("Grass", (Integer.parseInt(input2)), 50));
                }
            }

            if(input.equals("0")){
                break;
            }
        }

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
