package com.company;

import java.util.Random;

public class Car {


    //properties
    public String brand;
    public String color;
    public String segment;
    public Integer mileage;
    public Integer value;

    //parts is working = true; broken = false;
    public Boolean brakes = new Random().nextInt(25)!=0;
    public Boolean suspension = new Random().nextInt(25)!=0;
    public Boolean engine = new Random().nextInt(25)!=0;
    public Boolean body = new Random().nextInt(25)!=0;
    public Boolean transmission = new Random().nextInt(25)!=0;

    public Car( String brand, String color, String segment, Integer mileage, Integer value){
        this.brand = brand;
        this.color = color;
        this.segment = segment;
        this.mileage = mileage;
        this.value = value;
    }

}
