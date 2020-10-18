package com.company;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String CYAN_BRIGHT = "\033[0;96m";

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    String input3 = "";
    String input = "";
    String input2 = "";
    String inputName = "";
    String inputGender = "";
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
                System.out.println("\n".repeat(30));
                return;
            }
            animalSold(animals.get(Integer.parseInt(input) - 1));
            animals.remove(Integer.parseInt(input) - 1);
        }
    }


    public void buyFood() {
        if (money < 200) {
            System.out.println("\n".replace("\n", ""));
            System.out.println("You don't have enough money.");
            return;
        }
        Store.food(this);
    }

    public void animalSold(Animal a) {
        int profit = (a.healthPoints * a.price) / 100;
        money += profit;
    }

    public void deadAnimal() {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).healthPoints <= 0) {
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + animals.get(i).name + ANSI_RED + " has died..." + ANSI_RESET);
                animals.remove(i);
            }
        }
    }


    public void checkRabbitFood(Player p) {
        while (true) {

            System.out.println("What type of food???");

            int optionCounter2 = 1;
            for (int i = 0; i < p.food.size(); i++) {
                if (p.food.get(i).name.equals("Apple")) {
                    continue;
                } else if (p.food.get(i).name.equals("Grass")) {
                    continue;
                }
                System.out.println(optionCounter2 + "." + p.food.get(i).name + " " + p.food.get(i).kilos + "kg");
                optionCounter2++;
            }
            input3 = scanner.next();
            System.out.println("How many Kg?");
            input2 = scanner.next();
            System.out.println("\n".repeat(30));


            feedTheAnimal(animals.get(Integer.parseInt(input) - 1));
            p.food.get(Integer.parseInt(input3) - 1).kilos -= Integer.parseInt(input2);
            System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +
                    animals.get(Integer.parseInt(input) - 1).name + " has gained " + "+ " + (Integer.parseInt(input2) * 10) + "HP");
            break;
        }
    }


    public void feedAnimal(Player p) {

        while (true) {
            System.out.println("\n".repeat(2));
            System.out.println("[" + p.name + "]" + " Which Animal would you like to feed?");
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
                System.out.println("\n".repeat(25));
                return;
            }

            System.out.println("What type of food?");
            int optionCounter2 = 1;
            for (int i = 0; i < p.food.size(); i++) {
                if (p.food.get(i).kilos < 1) {
                    p.food.remove(i);
                }
                System.out.println(optionCounter2 + "." + p.food.get(i).name + " " + p.food.get(i).kilos + "kg");
                optionCounter2++;
            }

            input3 = scanner.next();
            if (input3.equals("0")) {
                System.out.println("\n".repeat(25));
                break;
            }

            if (p.food.get(Integer.parseInt(input3) - 1).name.equals(p.animals.get(Integer.parseInt(input) - 1).eats)) {

                System.out.println("How many Kg?");
                input2 = scanner.next();
                System.out.println("\n".repeat(30));

                feedTheAnimal(animals.get(Integer.parseInt(input) - 1));
                p.food.get(Integer.parseInt(input3) - 1).kilos -= Integer.parseInt(input2);
                for (int i = 0; i < p.animals.size(); i++) {
                    if (p.animals.get(i).healthPoints < 1) {
                        animals.remove(i);
                    }
                }
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +
                        animals.get(Integer.parseInt(input) - 1).name + " has gained " + "+ " + (Integer.parseInt(input2) * 10) + "HP");

            } else if (!p.food.get(Integer.parseInt(input3) - 1).name.equals(p.animals.get(Integer.parseInt(input) - 1).eats)) {
                System.out.println("\n".repeat(25));
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +
                        animals.get(Integer.parseInt(input) - 1).getClass().getSimpleName() + "'s don't eat that kind of food..");
            }


        }
    }

    public void feedTheAnimal(Animal a) {
        a.healthPoints += 10 * Integer.parseInt(input2);
    }


    public void mateAnimals(Player p) {

        Animal typeOfAnimal;

        while (true) {
            System.out.println("\n".repeat(2));
            System.out.println("STEP 1: \nChoose a (male) Animal: ");
            int optionCounter = 1;
            System.out.println("-".repeat(45));
            for (Animal a : p.animals) {
                System.out.println(optionCounter + "." + "(" + a.getClass().getSimpleName() + ")" + " " + a.name + "  "
                        + "(" + a.gender + ")" + "  " + a.healthPoints + "HP");
                optionCounter++;
            }
            System.out.println("-".repeat(45));
            System.out.println("0. EXIT");
            input = scanner.next();
            System.out.println("\n".repeat(2));
            if(input.equals("0")){
                break;
            }
            typeOfAnimal = animals.get(Integer.parseInt(input) - 1);
            if(typeOfAnimal.gender.equals("female")){
                System.out.println("Pick a male animal first..");
                mateAnimals(p);
            }


            System.out.println("STEP 2: \nChoose a (female) Animal: ");
            int optionCounter2 = 1;
            System.out.println("-".repeat(45));
            for (Animal a : p.animals) {
                System.out.println(optionCounter2 + "." + "(" + a.getClass().getSimpleName() + ")" + " " + a.name + "  "
                        + "(" + a.gender + ")" + "  " + a.healthPoints + "HP");
                optionCounter2++;
            }
            System.out.println("-".repeat(45));
            System.out.println("0. EXIT");
            input2 = scanner.next();
            System.out.println("\n".repeat(2));
            if(input2.equals("0")){
                break;
            }
            typeOfAnimal = animals.get(Integer.parseInt(input2) - 1);
            if(typeOfAnimal.gender.equals("male")){
                System.out.println("Pick in correct order: male > female..");
                mateAnimals(p);
            }

            System.out.println("\n".repeat(35));


            if (!p.animals.get(Integer.parseInt(input) - 1).gender.equals(p.animals.get(Integer.parseInt(input2) - 1).gender)) {

                if (typeOfAnimal.getClass().getSimpleName().equals("Sheep")) {
                    int babyCount = typeOfAnimal.maxBabies;
                    while (babyCount != 0) {
                        int num = 1 + random.nextInt(2);
                        if (num == 1) {
                            break;
                        } else {

                            int boyOrGirl = 1 + random.nextInt(2);
                            if (boyOrGirl == 1) {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a BOY!");
                                System.out.print("Name your Sheep: ");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "male", "Apple"));

                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.print("Name your Sheep: ");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "female", "Grass"));

                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 2) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
                        break;
                    }
                    return;
                }

                if (typeOfAnimal.getClass().getSimpleName().equals("Dog")) {

                    int babyCount = typeOfAnimal.maxBabies;
                    while (babyCount != 0) {
                        int num = 1 + random.nextInt(2);
                        if (num == 1) {
                            break;
                        } else {

                            int boyOrGirl = 1 + random.nextInt(2);
                            if (boyOrGirl == 1) {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a BOY!");
                                System.out.println("Name your Dog: ");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "male", "Apple"));

                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.println("Name your Dog");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "female", "Apple"));

                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 3) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
                        break;
                    }
                    return;
                }


                if (typeOfAnimal.getClass().getSimpleName().equals("Cat")) {

                    int babyCount = typeOfAnimal.maxBabies;
                    while (babyCount != 0) {
                        int num = 1 + random.nextInt(2);
                        if (num == 1) {
                            break;
                        } else {

                            int boyOrGirl = 1 + random.nextInt(2);
                            if (boyOrGirl == 1) {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a BOY!");
                                System.out.println("Name your Cat: ");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "male", "Apple"));

                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.println("Name your Cat");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "female", "Apple"));

                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 3) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
                        break;
                    }
                    return;
                }


                if (typeOfAnimal.getClass().getSimpleName().equals("Cow")) {

                    int babyCount = typeOfAnimal.maxBabies;
                    while (babyCount != 0) {
                        int num = 1 + random.nextInt(2);
                        if (num == 1) {
                            break;
                        } else {

                            int boyOrGirl = 1 + random.nextInt(2);
                            if (boyOrGirl == 1) {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a BOY!");
                                System.out.println("Name your Cow: ");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "male", "Grass"));

                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.println("Name your Cow");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "female", "Grass"));

                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 2) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
                        break;
                    }
                    return;
                }

                if (typeOfAnimal.getClass().getSimpleName().equals("Rabbit")) {

                    int babyCount = typeOfAnimal.maxBabies;
                    while (babyCount != 0) {
                        int num = 1 + random.nextInt(2);
                        if (num == 1) {
                            break;
                        } else {

                            int boyOrGirl = 1 + random.nextInt(2);
                            if (boyOrGirl == 1) {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a BOY!");
                                System.out.println("Name your Rabbit: ");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "male", "Carrot"));
                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.println("Name your Rabbit");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "female", "Carrot"));
                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 5) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
                        break;
                    }
                    return;
                }
            }
        }
    }
}







