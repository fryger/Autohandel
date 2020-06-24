package com.company;


import java.util.ArrayList;

import java.util.List;
import java.util.Random;


public class Store {

     List<Car> parking = new ArrayList<Car>();

    static String[] brands = {"Alfa Romeo", "Ford", "Jaguar", "Mercedes", "Tata"};
    private String[] colors = {"Copperhead Pearl", "True Blue", "Black Gold", "Construction Yellow", "Western Brown"};
    private String[] segments = {"Premium","Standard","Budget"};



    public void generateCar(int j) {
        for(int i= 1; i<=j;i++) {
            Random randomGenerator = new Random();
            Car car = new Car(brands[randomGenerator.nextInt(brands.length)],
                    colors[randomGenerator.nextInt(colors.length)],
                    segments[randomGenerator.nextInt(segments.length)],
                    randomGenerator.nextInt(1000000),
                    randomGenerator.nextInt(920)+80);
            parking.add(car);
        }
    }
    public void generateVan(int j) {
        for (int i = 1; i <= j; i++) {
            Random randomGenerator = new Random();
            Van car = new Van(brands[randomGenerator.nextInt(brands.length)],
                    colors[randomGenerator.nextInt(colors.length)],
                    segments[randomGenerator.nextInt(segments.length)],
                    randomGenerator.nextInt(1000000),
                    randomGenerator.nextInt(920)+80,
                    randomGenerator.nextInt(100));
            parking.add(car);
        }
    }

    public void sellCar(Human human,int id){
        Car temp = this.parking.get(id);
        Double addTax = ((2.0/100.0)*temp.value+temp.value);
        System.out.println("Car cost: " + temp.value + " Tax: "+ Math.round((2.0/100.0)*temp.value));
        if(human.CASH >= (int) Math.round(addTax)){
            human.CASH -= (int) Math.round(addTax);
            this.parking.remove(id);
            human.cars.add(temp);
            System.out.println("Account balance after purchase: " + human.CASH);
        }else{
            System.out.println("Insufficient founds");
        }
    }

}
