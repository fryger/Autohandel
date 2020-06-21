package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Owner me = new Owner();
        Store store= new Store();
        store.generateCar(15);
        store.generateVan(15);
        Scanner scanner = new Scanner(System.in);
        Boolean quit = true;
        while(quit) {
            System.out.println("1. View available cars ");
            System.out.println("2. Purchase car ");
            System.out.println("3. List your cars ");

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
                                store.parking.get(i).isFunctional,
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
                    System.out.format("| ID  |    Brand   |  Segment |        Color        |Car Type|Need repair|  Mileage  |Price |    Body   |   Engine  |Suspension |Transmision|%n");
                    System.out.format("+-----+------------+----------+---------------------+--------+-----------+-----------+------+-----------+-----------+-----------+-----------+%n");
                    for (int i = 0; i < me.cars.size(); i++) {
                        System.out.format(
                                leftAlignFormatCars,
                                i,
                                me.cars.get(i).brand,
                                me.cars.get(i).segment,
                                me.cars.get(i).color,
                                me.cars.get(i).getClass().getSimpleName(),
                                me.cars.get(i).isFunctional,
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
                    quit = false;
                    break;
                default:
                    System.out.println("Wrong number");
            }
        }
    }
}
