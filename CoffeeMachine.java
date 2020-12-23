package machine;

import java.util.Scanner;

public class MachineResources {
    private int water; // = 400;
    private int milk; // = 540;
    private int beans; // = 120;
    private int cups; // = 9;
    private int money; // = 550;

    public MachineResources(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getMoney() {
        return money;
    }
}

public class CoffeeMachine {

    public void Execute () {
        MachineResources machineResources = new MachineResources(400, 540, 102, 9, 200);
        printSupplies();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            // String action = scanner.next();
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
                    System.out.println("Nie poprawne!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new CoffeeMachine().Execute();
    }
    
    public static void printSupplies(MachineResources machineRes) {
        
        System.out.println("====== Coffee machine Status ======");
        System.out.printf("| water: %d ml | milk: %d ml | beans: %d g | cups: %d | money: $%d.00 |\n",
                machineRes.getWater(), machineRes.getMilk(), machineRes.getBeans(),
                machineRes.getCups(), machineRes.getMoney());
    }
    
    public static void buyCoffee(MachineResources machineRes) {
        
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.nextLine();
        switch(choice) {
            case "1":
                checkSuppliesEspresso(machineRes);
                break;
            case "2":
                checkSuppliesLatte(machineRes);
                break;
            case "3":
                checkSuppliesCappuccino(machineRes);
                break;
            case "back": 
                break; 
            default:
                System.out.println("Invalid command!");
                break;
        }
    }
    
    public static void fillSupplies(MachineResources machineRes) {
        
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
    
    public static void takeMoney(MachineResources machineRes) {
        
        System.out.println("I gave you $" + money);
        money -= money;
    }
    
    public static void checkSuppliesEspresso(MachineResources machineRes) {
        
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
    
    public static void checkSuppliesLatte(MachineResources machineRes) {
        
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
    
    public static void checkSuppliesCappuccino(MachineResources machineRes) {
        
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