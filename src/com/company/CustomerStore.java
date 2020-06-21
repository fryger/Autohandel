package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerStore {
    List<Customer> customerList = new ArrayList<Customer>();

   void GenerateCustomer(){
       Random randomGenerator = new Random();
       String prefBrandFirst = Store.brands[randomGenerator.nextInt(Store.brands.length)];
       String prefBrandSecond = Store.brands[randomGenerator.nextInt(Store.brands.length)];
       while(prefBrandFirst == prefBrandSecond ){
           prefBrandSecond = Store.brands[randomGenerator.nextInt(Store.brands.length)];
       }

       Customer customer = new Customer(
               prefBrandFirst,
               prefBrandSecond,
               new Random().nextInt(25)==0,
               new Random().nextInt(25)==0
       );
       customerList.add(customer);
   }
}
