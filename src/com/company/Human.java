package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Human {
    private Random randomGenerator = new Random();;
    public Integer CASH = randomGenerator.nextInt(1000) + 1;;

    static public List<Car> cars = new ArrayList<Car>();
}
