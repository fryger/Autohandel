package com.company;

import java.util.Random;

public class Human {
    private Random randomGenerator = new Random();
    private int randomInt = randomGenerator.nextInt(1000) + 1;
    public Double CASH = (double) randomInt;

}
