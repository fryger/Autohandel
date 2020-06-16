package com.company;

public class Van extends Car {

    public Integer cargoSpace;
    public Van(String brand, String color, String segment, Integer mileage, Double value, Integer cargoSpace) {
        super(brand, color, segment, mileage, value);
        this.cargoSpace = cargoSpace;
    }


}
