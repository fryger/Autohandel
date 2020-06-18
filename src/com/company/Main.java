package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Owner me = new Owner();
        System.out.println(me.CASH);

        Car Brera = new Car("Alfa","Red","premium",10000,10);
        System.out.println(Brera.brand);

        //System.out.println(owners.get(0).brand);


        Store store= new Store();
        store.generateCar(15);
        store.generateVan(5);

        System.out.println(store.parking.size());
        store.sellCar(me,12);
        System.out.println(store.parking.size());
        System.out.println(me.cars.get(0).brand);


    }
}
