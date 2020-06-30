package com.company;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Owner me = new Owner();
        Store store= new Store();
        List<Mechanic> workshop = new ArrayList<Mechanic>();
        Mechanic Janusz = new Mechanic(2.0,1,"Janusz");
        Mechanic Marian = new Mechanic(1.0,10,"Marian");
        Mechanic Adrian = new Mechanic(0.5,20,"Adrian");
        workshop.add(Janusz);
        workshop.add(Marian);
        workshop.add(Adrian);
        store.generateCar(25);
        store.generateVan(5);
        CustomerStore customerStore = new CustomerStore();
        customerStore.GenerateCustomer(10);

        Scanner scanner = new Scanner(System.in);
        Boolean quit = true;
        while(quit) {
            System.out.println("1. View available cars ");
            System.out.println("2. Purchase car ");
            System.out.println("3. List your cars ");
            System.out.println("4. Repair car ");
            System.out.println("5. List customers ");
            System.out.println("6. Sell car ");
            System.out.println("7. Buy Ad ");
            System.out.println("8. Account balance ");
            System.out.println("9. Transaction history ");
            System.out.println("10. Car repair history ");

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


                    System.out.println("Customer list");

                    String leftAlignFormatCustomer = "| %-3d | %-10s | %-22s | %-12s | %-9s |%n";

                    System.out.format("+-----+------------+------------------------+--------------+-----------+%n");
                    System.out.format("| ID  |    Cash    |     Preferred Brand    | Want Broken? | Want Van? |%n");
                    System.out.format("+-----+------------+------------------------+--------------+-----------+%n");
                    for (int i = 0; i < customerStore.customerList.size(); i++) {
                        System.out.format(
                                leftAlignFormatCustomer,
                                i,
                                customerStore.customerList.get(i).CASH,
                                customerStore.customerList.get(i).prefBrand,
                                customerStore.customerList.get(i).wantBroken,
                                customerStore.customerList.get(i).wantVan
                        );
                    }
                    System.out.format("+-----+------------+------------------------+--------------+-----------+%n");

                    break;
                case 6:
                    if(me.cars.size() == 0){
                        System.out.println("You don't have any car");
                        break;
                    }
                    System.out.println("Which car do you want to sell? [ID]");
                    int sellCarChooice = scanner.nextInt();
                    if(me.cars.get(sellCarChooice).isDirty == true){
                        System.out.println("Car must be clean before selling to customer!");
                        System.out.println("Do you want clean it now? [0- no; 1- yes]");
                        int clean = scanner.nextInt();
                        if(clean == 1){
                            me.washCar(sellCarChooice);
                        }else{
                            break;
                        }
                    }
                    System.out.println("Which customer do you want to sell it to? [ID]");
                    int clientId = scanner.nextInt();
                    System.out.println("How much do you want to put it up for sale?");
                    int price = scanner.nextInt();
                    customerStore.customerList.get(clientId).sellCarCheck(me,sellCarChooice,price);
                    if(customerStore.customerList.get(clientId).transactionStatus){
                        customerStore.customerList.remove(clientId);
                        customerStore.GenerateCustomer(2);
                    }
                    break;
                case 7:
                    System.out.println("Marketing");

                    System.out.println("0. Local newspaper" + " Cost: 100");
                    System.out.println("1. Online Ad" + " Cost: 50");
                    int adid = scanner.nextInt();
                    System.out.println(adid);
                    if(adid == 0) {
                        if (me.CASH >= 40) {
                            me.CASH -= 40;
                            int randomClient = randomGenerator.nextInt(3) + 1;
                            customerStore.GenerateCustomer(randomClient);
                            System.out.println(randomClient + " new customers have arrived");
                            me.movementsList.add("You bought newspaper Ad, " + randomClient + " new customers arrived");
                        }
                    }
                    if(adid == 1) {
                        if (me.CASH >= 20) {
                            me.CASH -= 20;
                            int randomClient = randomGenerator.nextInt(3) + 1;
                            customerStore.GenerateCustomer(randomClient);
                            System.out.println("One new customers have arrived");
                            me.movementsList.add("You bought Online Ad, one new customer arrived");
                        }
                    }
                    break;
                case 8:
                    System.out.println("Your account balance: " + me.CASH);
                    break;
                case 9:
                    System.out.println("Movements count: " + me.movementsList.size());
                    for(int j=0; j< me.movementsList.size();j++){
                        System.out.println(j+1 + ".  "+me.movementsList.get(j));
                    }
                    break;
                case 10:
                    System.out.println("Lookup car repair history");
                    System.out.println("Provide car ID");
                    int carChoiceHistory = scanner.nextInt();
                    me.carHistory(carChoiceHistory);
                    break;
                case 11:
                    quit = false;
                    break;
                default:
                    System.out.println("Wrong number");
            }
        }
    }
}
