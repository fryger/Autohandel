package com.company;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Human {

    public void washCar(Integer id){
        if(this.CASH >= 10){
            this.cars.get(id).isDirty = false;
            System.out.println("Car " + this.cars.get(id).brand + " is clean");
        }
    }
}
