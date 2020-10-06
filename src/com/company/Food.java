package com.company;

abstract public class Food {

    public String name;
    public int kilos;
    public int price;


    public Food(String name, int kilos, int price){
        this.kilos = kilos;
        this.price = price;
        this.name = name;
    }


}
