package machine;

import java.util.Scanner;

public class CoffeeMachine {
    
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    
    public static void main(String[] args) {
        
        while (true) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();
            
            if (action.equals("exit")) {
                break;
            }
            
            switch(action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillSupplies();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printSupplies();
                    break;
                default:
                    System.out.println("Invalid!");
                    break;
            }
        }
    }
    
    public static void printSupplies() {
        
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
    
    public static void buyCoffee() {
        
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.nextLine();
        switch(choice) {
            case "1":
                checkSuppliesEspresso();
                break;
            case "2":
                checkSuppliesLatte();
                break;
            case "3":
                checkSuppliesCappuccino();
                break;
            case "back": 
                break; 
            default:
                System.out.println("Invalid command!");
                break;
        }
    }
    
    public static void fillSupplies() {
        
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scanner.nextInt();
        water += addWater;
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = scanner.nextInt();
        milk += addMilk;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int addBeans = scanner.nextInt();
        beans += addBeans;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scanner.nextInt();
        cups += addCups;
    }
    
    public static void takeMoney() {
        
        System.out.println("I gave you $" + money);
        money -= money;
    }
    
    public static void checkSuppliesEspresso() {
        
        if (water >= 250 && beans >= 16 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            beans -= 16;
            cups -= 1;
            money += 4;
        } else if (water < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (beans < 16) {
            System.out.println("Sorry, not enough beans!"); 
        } else {
            System.out.println("Sorry, not enough cups!");
        }
    }
    
    public static void checkSuppliesLatte() {
        
        if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups -= 1;
            money += 7;
        } else if (water < 350) {
            System.out.println("Sorry, not enough water!"); 
        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 20) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("Sorry, not enough cups!");
        }
    }
    
    public static void checkSuppliesCappuccino() {
        
        if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups -= 1;
            money += 6;
        } else if (water < 200) {
            System.out.println("Sorry, not enough water!");     
        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 12) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("Sorry, not enough cups!");
        }
    }
}