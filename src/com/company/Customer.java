package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer extends Human {
    Random randomGenerator = new Random();

    public ArrayList<String> prefBrand = new ArrayList<String>(2);
    public Boolean wantVan;
    public Boolean wantBroken;

    public Customer(String prefBrandFirst,String prefBrandSecond, Boolean wantVan, Boolean wantBroken){
        this.prefBrand.add(prefBrandFirst);
        this.prefBrand.add(prefBrandSecond);
        this.wantVan = wantVan;
        this.wantBroken = wantBroken;
    }
}
