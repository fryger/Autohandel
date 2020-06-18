package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Owner me = new Owner();
        System.out.println(me.CASH);
        System.out.println(me.business.name);

        Car Brera = new Car("Alfa","Red","premium",10000,10);
        System.out.println(Brera.brand);

        //System.out.println(owners.get(0).brand);


        Store Store= new Store();
        Store.generateCar(15);
        Store.generateVan(5);




    }
}
