package com.company;

public class Car {

    //properties
    public String brand;
    public String color;
    public String segment;
    public Integer mileage;
    public Double value;

    //parts
    private Double brakes;
    private Double suspension;
    private Double engine;
    private Double body;
    private Double transmission;

    public Car( String brand, String color, String segment, Integer mileage, Double value){
        this.brand = brand;
        this.color = color;
        this.segment = segment;
        this.mileage = mileage;
        this.value = value;
    }

}
