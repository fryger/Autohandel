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

    public void carHistory(int i){
        if(this.cars.size() == 0){
            System.out.println("No car in parking lot");
        }else {

            if (this.cars.get(i).repairList.size() < i) {
                System.out.println("No car on this spot");
            }
            for (int j = 0; j < this.cars.get(i).repairList.size(); j++) {
                System.out.println(this.cars.get(i).repairList.get(j));
            }
        }
    }
}
