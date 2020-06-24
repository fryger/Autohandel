package com.company;

import java.util.Random;

public class Mechanic {

    // (int) x price of parts
    private Double priceMod;
    // chance of repair 1-100%; 10 - 10%; 5 -20%
    private Boolean failureChance;
    //price list
    private Double engineRepPrice = 50.0;
    private Double transmissionRepPrice = 40.0;
    private Double bodyRepPrice = 30.0;
    private Double suspensionRepPrice = 20.0;
    private Double brakesRepPrice = 10.0;
    private String name;

    public Mechanic(Double priceMod, Integer failureChance,String name){
    this.priceMod= priceMod;
    this.failureChance= new Random().nextInt(failureChance)!=0;
    this.name = name;

}
    public String getName() {
        return this.name;
    }

public void repCar(Owner owner,Integer carid){
    carPrice(owner,carid);
    Double bill = 0.0;
    Integer carValue = owner.cars.get(carid).value;
    if(owner.cars.get(carid).engine == false){bill+=engineRepPrice;}
    if(owner.cars.get(carid).transmission == false){bill+=transmissionRepPrice;}
    if(owner.cars.get(carid).body == false){bill+=bodyRepPrice;}
    if(owner.cars.get(carid).suspension == false){bill+=suspensionRepPrice;}
    if(owner.cars.get(carid).brakes == false){bill+=brakesRepPrice;}
    if(owner.CASH < bill){
        System.out.println("Insufficient founds");
    }else{
        owner.CASH -=  (int) Math.round(bill);
        System.out.println(bill);
        System.out.println(owner.CASH);
        if(owner.cars.get(carid).engine == false){
            owner.cars.get(carid).engine = true && !failureChance;
            if(owner.cars.get(carid).engine == true) {
                owner.cars.get(carid).value *= 2;
            }
        }
        if(owner.cars.get(carid).transmission == false){
            owner.cars.get(carid).transmission = true && !failureChance;
            if(owner.cars.get(carid).transmission == true) {
                owner.cars.get(carid).value += ((50 / 100) * owner.cars.get(carid).value);
            }
        }
        if(owner.cars.get(carid).body == false){
            owner.cars.get(carid).body = true && !failureChance;
            if(owner.cars.get(carid).body == true) {
                owner.cars.get(carid).value += ((50 / 100) * owner.cars.get(carid).value);
            }
        }
        if(owner.cars.get(carid).suspension == false) {
            owner.cars.get(carid).suspension = true && !failureChance;
            if (owner.cars.get(carid).suspension == true) {
                owner.cars.get(carid).value += ((20 / 100) * owner.cars.get(carid).value);
            }
        }
        if(owner.cars.get(carid).brakes == false){
            owner.cars.get(carid).brakes = true && !failureChance;
            if(owner.cars.get(carid).brakes == true) {
                owner.cars.get(carid).value += ((10 / 100) * owner.cars.get(carid).value);
            }
        }
        if(owner.cars.get(carid).engine && owner.cars.get(carid).transmission && owner.cars.get(carid).body && owner.cars.get(carid).suspension && owner.cars.get(carid).brakes) {
            owner.cars.get(carid).isFunctional = true;
        }
    }
}

private void carPrice(Owner owner,Integer carid){
    String carBrand = owner.cars.get(carid).brand;
    Double carBrandPriceMod = 1.0;
    if(carBrand == "Alfa Romeo"){carBrandPriceMod = 0.8;}
    if(carBrand == "Ford"){carBrandPriceMod = 0.5;}
    if(carBrand == "Jaguar"){carBrandPriceMod = 1.2;}
    if(carBrand == "Mercedes"){carBrandPriceMod = 1.0;}
    if(carBrand == "Tata"){carBrandPriceMod = 0.2;}

    engineRepPrice = engineRepPrice * priceMod *  carBrandPriceMod;
    transmissionRepPrice = transmissionRepPrice * priceMod *  carBrandPriceMod;
    bodyRepPrice = bodyRepPrice * priceMod *  carBrandPriceMod;
    suspensionRepPrice = suspensionRepPrice * priceMod *  carBrandPriceMod;
    brakesRepPrice = brakesRepPrice * priceMod *  carBrandPriceMod;
}
}


