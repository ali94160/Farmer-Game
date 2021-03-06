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

    public static final String RED_BOLD = "\033[1;31m";    // Bold RED
    public static final String GREEN_BOLD = "\033[1;32m";  // Bold GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // Bold YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // Bold BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // Bold PURPLE
    public static final String WHITE_BOLD = "\033[1;37m";  // Bold WHITE

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    String input3 = "";
    String input = "";
    String input2 = "";
    String inputName = "";
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
            System.out.println("[" + BLUE_BOLD + p.name + ANSI_RESET + "]" + " What Animals would you like to sell:");
            System.out.println("Balance: $" + money);
            System.out.println("-".repeat(55));
            int optionCounter = 1;
            for (Animal a : p.animals) {
                System.out.println(optionCounter + "." + "(" + a.getClass().getSimpleName() + ")" + " | " + a.name + "  "
                        + "(" + a.gender + ")" + " | " + a.healthPoints + "HP" + " | Sell for: $" + (a.price * a.healthPoints) / 100);
                optionCounter++;
            }
            System.out.println("-".repeat(55));
            System.out.println("0. EXIT");
            while(true) {
                if(p.animals.size() <= 0){
                    System.out.println("\n".repeat(20));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"No animals left to sell.");
                    return;
                }
                try {
                    input3 = scanner.next();
                    if(Integer.parseInt(input3)-1 > optionCounter-1 ){
                        System.out.println("Invalid input");
                    } else{
                        break;
                    }
                } catch (Exception err){
                    System.out.println("Invalid input");
                }
            }
            System.out.println("\n".repeat(30));

            if (input3.equals("0")) {
                System.out.println("\n".repeat(30));
                return;
            }
            animalSold(animals.get(Integer.parseInt(input3) - 1));
            animals.remove(Integer.parseInt(input3) - 1);
        }
    }


    public void buyFood() {
        if (money < 40) {
            System.out.println("\n".replace("\n", ""));
            System.out.println("You don't have enough money.");
            return;
        }
        Store.food(this);
    }

    public void animalSold(Animal a) {
        int profit = (a.healthPoints * a.price) / 100;
        money += profit;
        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"You gained $" + ANSI_GREEN + profit + ANSI_RESET + " to your balance." + "\n");
    }
    public void sellAllAnimals(Animal a) {
        int profit = (a.healthPoints * a.price) / 100;
        money += profit;
    }

    public void deadAnimal() {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).healthPoints <= 0) {
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + animals.get(i).name + ANSI_RED + " has died..." + ANSI_RESET);
                animals.remove(animals.get(i));
                deadAnimal();
            }
        }
    }


    public void feedAnimal(Player p) {

        while (true) {

            System.out.println("\n".repeat(2));
            System.out.println("[" + BLUE_BOLD + p.name + ANSI_RESET + "]" + " Which Animal would you like to feed?");
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

            System.out.println("\n".repeat(25));
            if (input.equals("0")) {
                System.out.println("\n".repeat(25));
                return;
            }

            System.out.println("----- [Food Info] -----");
            System.out.println(BLUE_BOLD + "Dog/Cat" + ANSI_RESET +" eats:" + BLUE_BOLD +" Apples." + ANSI_RESET);
            System.out.println(PURPLE_BOLD + "Rabbit" + ANSI_RESET +" eats:" + PURPLE_BOLD +" Carrots." + ANSI_RESET);
            System.out.println(GREEN_BOLD + "Sheep/Cow" + ANSI_RESET +" eats:" + GREEN_BOLD + " Grass." + ANSI_RESET);
            System.out.println("-".repeat(23));
            System.out.println("You've picked: " + p.animals.get(Integer.parseInt(input)-1).getClass().getSimpleName());
            System.out.println("\nWhat type of food?");


            int optionCounter2 = 1;
            for (int i = 0; i < p.food.size(); i++) {
                if (p.food.get(i).kilos < 1) {
                    p.food.remove(i);
                    break;
                }
                System.out.println(optionCounter2 + "." + p.food.get(i).name + " " + p.food.get(i).kilos +  "kg");
                optionCounter2++;

            }
            if(p.food.size() < 1){
                System.out.println("\n".repeat(30));
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "You ran out of food supplies.");
                return;
            }

            while(true) {
                try {
                    input3 = scanner.next();
                    if(Integer.parseInt(input3)-1 > p.food.size()-1 || Integer.parseInt(input3)-1 < 0){
                        System.out.println("Invalid input");
                    } else if(Integer.parseInt(input3)-1 == 2){
                        System.out.println("Invalid input");
                    }
                    else {
                        break;
                    }
                } catch (Exception err){
                    System.out.println("Invalid input");
                }
            }

            if (input3.equals("0")) {
                System.out.println("\n".repeat(25));
                break;
            }

            if (p.food.get(Integer.parseInt(input3) - 1).name.equals(p.animals.get(Integer.parseInt(input) - 1).eats)) {
                while(true) {
                    System.out.println("How many Kg?");
                    try {
                        input2 = scanner.next();
                            if (Integer.parseInt(input2) > food.get(Integer.parseInt(input3)-1).kilos) {
                                System.out.println("\n".repeat(30));
                                System.out.println("You don't have enough kg.");
                            }
                            if (Integer.parseInt(input2) < 0){
                                System.out.println("Invalid input");

                            }
                        if(Integer.parseInt(input2) > 0 && Integer.parseInt(input2) <= food.get(Integer.parseInt(input3)-1).kilos){
                            break;
                        }
                        }catch(Exception e){
                            System.out.println("Invalid input");
                        }
                }
                    System.out.println("\n".repeat(35));
                    feedTheAnimal(animals.get(Integer.parseInt(input) - 1));
                    p.food.get(Integer.parseInt(input3) - 1).kilos -= Integer.parseInt(input2);
                    for (int i = 0; i < p.animals.size(); i++) {
                        if (p.animals.get(i).healthPoints < 1) {
                            animals.remove(i);
                            break;
                        }
                    }
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +
                        animals.get(Integer.parseInt(input) - 1).name + " has gained " + "+ " + (Integer.parseInt(input2) * 10) + "HP");

                } if (!p.food.get(Integer.parseInt(input3) - 1).name.equals(p.animals.get(Integer.parseInt(input) - 1).eats)) {
                    System.out.println("\n".repeat(25));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +
                            animals.get(Integer.parseInt(input) - 1).getClass().getSimpleName() + "'s don't eat that kind of food..");
                }
            }
        }


    public void feedTheAnimal(Animal a) {
        a.healthPoints += 10 * Integer.parseInt(input2);
        if(a.healthPoints > 100){
            a.healthPoints = 100;
        }
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
            try {
                input = scanner.next();
                if(Integer.parseInt(input) > animals.size() || Integer.parseInt(input) < 0){
                    System.out.println("\n".repeat(30));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                    mateAnimals(p);
                }
            } catch (Exception e){
                System.out.println("\n".repeat(30));
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                mateAnimals(p);
            }

            System.out.println("\n".repeat(2));
            if(input.equals("0")){
                break;
            }
            typeOfAnimal = animals.get(Integer.parseInt(input) - 1);
            if(typeOfAnimal.gender.equals("female")){
                System.out.println("\n".repeat(30));
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Pick a male animal first..");
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

            try {
                input2 = scanner.next();
                if(Integer.parseInt(input2) > animals.size() || Integer.parseInt(input2) < 1){
                    System.out.println("\n".repeat(30));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                    mateAnimals(p);
                }
            } catch (Exception e){
                System.out.println("\n".repeat(30));
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Invalid input");
                mateAnimals(p);
            }

            System.out.println("\n".repeat(2));
            if(input2.equals("0")){
                break;
            } else {

                typeOfAnimal = animals.get(Integer.parseInt(input2) - 1);
                if (typeOfAnimal.gender.equals("male")) {
                    System.out.println("\n".repeat(30));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Pick in correct order: male > female..");
                    mateAnimals(p);
                }
                System.out.println("\n".repeat(35));


                if (!p.animals.get(Integer.parseInt(input2) - 1).getClass().getSimpleName().equals
                        (p.animals.get(Integer.parseInt(input) - 1).getClass().getSimpleName())) {
                    System.out.println("\n".repeat(30));
                    System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET +"Has to be same animal");
                    mateAnimals(p);
                    return;

                }
            }


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
                                p.animals.add(new Sheep(inputName, "male", "Grass"));

                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.print("Name your Sheep: ");
                                inputName = scanner.next();
                                p.animals.add(new Sheep(inputName, "female", "Grass"));

                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 2) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
                        return;
                    }
                }

                if (typeOfAnimal.getClass().getSimpleName().equals("Dog")) {

                    int babyCount = typeOfAnimal.maxBabies;
                    while (babyCount != 0) {
                        int num = 1 + random.nextInt(2);
                        if (num == 1) {
                            break;
                        } else if (num == 2) {

                            int boyOrGirl = 1 + random.nextInt(2);
                            if (boyOrGirl == 1) {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a BOY!");
                                System.out.println("Name your Dog: ");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "male", "Apple"));
                                System.out.println("\n".repeat(25));


                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.println("Name your Dog: ");
                                inputName = scanner.next();
                                p.animals.add(new Dog(inputName, "female", "Apple"));
                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 3) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
                        return;
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
                                p.animals.add(new Cat(inputName, "male", "Apple"));

                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.println("Name your Cat: ");
                                inputName = scanner.next();
                                p.animals.add(new Cat(inputName, "female", "Apple"));

                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 3) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
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
                                p.animals.add(new Cow(inputName, "male", "Grass"));

                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.println("Name your Cow: ");
                                inputName = scanner.next();
                                p.animals.add(new Cow(inputName, "female", "Grass"));

                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 2) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
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
                                p.animals.add(new Rabbit(inputName, "male", "Carrot"));
                                System.out.println("\n".repeat(25));

                            } else {
                                System.out.println(ANSI_GREEN + "Congratulation!" + ANSI_RESET + " Its a GIRL!");
                                System.out.println("Name your Rabbit: ");
                                inputName = scanner.next();
                                p.animals.add(new Rabbit(inputName, "female", "Carrot"));
                                System.out.println("\n".repeat(25));
                            }
                            babyCount--;
                        }
                    }
                    if (babyCount == 5) {
                        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Sorry, didn't mate any animals this time..");
                    }
                    return;
                }
            }
        }
    }

    public void gotSick(Player p){
        int sick = 1+ random.nextInt(5);

        if(sick == 5){
            for(int i = 0; i < p.animals.size(); i++){
                System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + p.name + ": Your animal " + "[" + p.animals.get(i).name +"]"
                        + "[" + p.animals.get(i).healthPoints + " HP] has been sick!");
                System.out.println("-".repeat(40));
                System.out.println("You need to take your animal to the vet.");
                System.out.println("1. Pay the veterinary cost. [$1000]");
                System.out.println("2. Decline, your animal will die.");
                p.animals.get(random.nextInt(animals.size()));

while(true) {
    try {
        String input = scanner.next();

    if (Integer.parseInt(input) == 1) {
        if (p.money < 1000) {
            System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "You don't have enough money, your animal will die.");
            p.animals.remove(i);
            break;
        } else {
            int sickChance = 1 + random.nextInt(2);

            if (sickChance == 1) {
                p.animals.get(i).healthPoints += 10 * 100;
                if (p.animals.get(i).healthPoints > 100) {
                    p.animals.get(i).healthPoints = 100;
                }
                p.money -= 1000;
                System.out.println(ANSI_GREEN + "Your animal survived!" + ANSI_RESET);
                return;
            } else {
                System.out.println(ANSI_RED + "Your animal didn't make it." + ANSI_RESET);
                p.animals.remove(i);
                break;
            }
        }
    } else if (Integer.parseInt(input) == 2) {
        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "You've declined the payment.");
        p.animals.remove(i);
        break;
    } else if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 2) {
        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Invalid input");
        gotSick(p);
        break;
    }
    } catch (Exception error) {
        System.out.println(CYAN_BRIGHT + "[Game]: " + ANSI_RESET + "Invalid input");
    }
}


            }



        }

    }

}







