package com.company;
import java.util.*;
public class Game {

    Scanner scanner = new Scanner(System.in);
    int roundInput;
    int playerInput;
    String playerName;
    ArrayList<Player> players = new ArrayList<>();

    public Game (){

        System.out.println("How many rounds would you like to play?");
        roundInput = scanner.nextInt();
        System.out.println("How many players?");
        playerInput = scanner.nextInt();

        for(int i = 0; i < playerInput; i++){
            System.out.println("Player " + (i + 1) +
                    ", Enter your name:");
            playerName = scanner.next();
            players.add(new Player(playerName));
        }

        for(Player p : players){
            playerName = p.name;
            System.out.println(p.name);
        }





    }



}
