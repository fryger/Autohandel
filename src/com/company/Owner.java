package com.company;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;

public class Owner {

    private Random randomGenerator = new Random();
    private int randomInt = randomGenerator.nextInt(1000) + 1;
    public Double CASH = (double) randomInt;

    public Company business= new Company();

}
