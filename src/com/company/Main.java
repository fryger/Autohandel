package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Owner me = new Owner();
        Store store= new Store();
        List<Mechanic> workshop = new ArrayList<Mechanic>();
        Mechanic Janusz = new Mechanic(2.0,1,"Janusz");
        Mechanic Marian = new Mechanic(1.0,10,"Marian");
        Mechanic Adrian = new Mechanic(0.5,20,"Adrian");
        workshop.add(Janusz);
        workshop.add(Marian);
        workshop.add(Adrian);
        store.generateCar(15);
        store.generateVan(15);
        Scanner scanner = new Scanner(System.in);
        Boolean quit = true;
        while(quit) {
            System.out.println("1. View available cars ");
            System.out.println("2. Purchase car ");
            System.out.println("3. List your cars ");
            System.out.println("4. Repair car ");

        int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String leftAlignFormat = "| %-3d | %-10s | %-8s | %-19s | %-6s | %-9s |%-5d |%n";

                    System.out.format("+-----+------------+----------+---------------------+--------+-----------+------+%n");
                    System.out.format("| ID  |    Brand   |  Segment |        Color        |Car Type|Need repair|Price |%n");
                    System.out.format("+-----+------------+----------+---------------------+--------+-----------+------+%n");
                    for (int i = 0; i < store.parking.size(); i++) {
                        System.out.format(
                                leftAlignFormat,
                                i,
                                store.parking.get(i).brand,
                                store.parking.get(i).segment,
                                store.parking.get(i).color,
                                store.parking.get(i).getClass().getSimpleName(),
                                !store.parking.get(i).isFunctional,
                                store.parking.get(i).value
                        );
                    }
                    System.out.format("+-----+------------+----------+---------------------+--------+-----------+------+%n");
                    break;
                case 2:
                    System.out.println("Account balance: " + me.CASH);
                    System.out.println("Which car you want buy: " );
                    int carchooice = scanner.nextInt();
                    store.sellCar(me,carchooice);
                    break;
                case 3:
                    System.out.println("Your cars");

                    String leftAlignFormatCars = "| %-3d | %-10s | %-8s | %-19s | %-6s | %-9s |%-10d |%-5d | %-9s | %-9s | %-9s | %-9s |%n";

                    System.out.format("+-----+------------+----------+---------------------+--------+-----------+-----------+------+-----------+-----------+-----------+-----------+%n");
                    System.out.format("| ID  |    Brand   |  Segment |        Color        |Car Type|Need repair|  Mileage  |Value |    Body   |   Engine  |Suspension |Transmision|%n");
                    System.out.format("+-----+------------+----------+---------------------+--------+-----------+-----------+------+-----------+-----------+-----------+-----------+%n");
                    for (int i = 0; i < me.cars.size(); i++) {
                        System.out.format(
                                leftAlignFormatCars,
                                i,
                                me.cars.get(i).brand,
                                me.cars.get(i).segment,
                                me.cars.get(i).color,
                                me.cars.get(i).getClass().getSimpleName(),
                                !me.cars.get(i).isFunctional,
                                me.cars.get(i).mileage,
                                me.cars.get(i).value,
                                me.cars.get(i).body,
                                me.cars.get(i).engine,
                                me.cars.get(i).suspension,
                                me.cars.get(i).brakes
                        );
                    }
                    System.out.format("+-----+------------+----------+---------------------+--------+-----------+-----------+------+-----------+-----------+-----------+-----------+%n");
                    break;
                case 4:
                    if(me.cars.size() == 0){
                        System.out.println("You don't have any cars to repair");
                        break;
                    }
                    System.out.println("Which car you want to repair");
                    int ownercarchooice = scanner.nextInt();
                    System.out.println("Choose your mechanic");
                    for(int i=0; i < workshop.size();i++){
                        System.out.println(i + " " + workshop.get(i).getName());
                    }
                    int mechanicchooice = scanner.nextInt();
                    workshop.get(mechanicchooice).repCar(me,ownercarchooice);

                    break;
                case 5:
                    quit = false;
                    break;
                default:
                    System.out.println("Wrong number");
            }
        }
    }
}
