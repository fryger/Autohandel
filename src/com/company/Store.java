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
                    randomGenerator.nextInt(1000)+1);
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
                    randomGenerator.nextInt(1000),
                    randomGenerator.nextInt(100));
            parking.add(car);
        }
    }

    public void sellCar(Human human,int id){
        Car temp = this.parking.get(id);
        System.out.println("Car cost: " + temp.value);
        if(human.CASH >= temp.value){
            human.CASH -= temp.value;
            this.parking.remove(id);
            human.cars.add(temp);
            System.out.println("Account balance after purchase: " + human.CASH);
        }else{
            System.out.println("Insufficient founds");
        }
    }

}
