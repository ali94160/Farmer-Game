package com.company;

public class Cat extends Animal{

    public int price;
    public Cat(String name, String gender) {
        super(name, gender);
        this.price = 1000;
    }
}
