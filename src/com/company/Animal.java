package com.company;

import java.util.ArrayList;

abstract public class Animal {


    public int healthPoints;
    public int price;
    public String name;
    public String gender;
    public int maxBabies;

    public Animal(String name, String gender){

        this.gender = gender;
        this.name = name;
        this.healthPoints = 100;
        this.maxBabies = 0;


}




}
