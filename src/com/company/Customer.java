package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer extends Human {
    Random randomGenerator = new Random();

    public ArrayList<String> prefBrand = new ArrayList<String>(2);
    public Boolean wantVan;
    public Boolean wantBroken;
    public Boolean transactionStatus = false;

    public Customer(String prefBrandFirst,String prefBrandSecond, Boolean wantVan, Boolean wantBroken){
        this.prefBrand.add(prefBrandFirst);
        this.prefBrand.add(prefBrandSecond);
        this.wantVan = wantVan;
        this.wantBroken = wantBroken;
    }

    public void sellCarCheck(Human human,Integer id, Integer price){
        Integer check = 0;
        if(!human.cars.get(id).isFunctional){if(this.wantBroken){}else{check += 1;}}
        if(this.prefBrand.contains(human.cars.get(id).brand)){}else{check += 1;}

        if(this.wantVan){
            if(Human.cars.get(id).getClass().getSimpleName().contains("Van")){}else {check += 1;}
        }else{
            if(Human.cars.get(id).getClass().getSimpleName().contains("Car")){}else {check += 1;}
        }

        if(price > this.CASH){check += 1;}


        if(check > 0){
            System.out.println("Car does't meet my requirements");
        }else if(check == 0){
            this.CASH -= price;
            Double tax = (2.0/100.0)*price;
            human.CASH -= tax.intValue();
            human.cars.remove(id);
            System.out.println("Samochód został sprzedany");
            transactionStatus = true;
        }
    }
}
