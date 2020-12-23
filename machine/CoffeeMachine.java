package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public void Execute () {
        MachineResources machineResources = new MachineResources(400, 540, 102, 9, 200);
        printSupplies(machineResources);
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
                    buyCoffee(machineResources);
                    break;
                case "fill":
                    machineResources = fillSupplies(machineResources);
                    break;
                case "take":
                    takeMoney(machineResources);
                    break;
                case "remaining":
                    printSupplies(machineResources);
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
        Scanner scanner = new Scanner(System.in);
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
    
    public static MachineResources fillSupplies(MachineResources machineRes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scanner.nextInt();

        return new MachineResources(
                machineRes.getWater()+addWater,
                machineRes.getMilk()+addMilk,
                machineRes.getBeans()+addBeans,
                machineRes.getCups()+addCups,
                machineRes.getMoney());
    }
    
    public static void takeMoney(MachineResources machineRes) {
        
        System.out.println("I gave you $" + machineRes.getMoney());
        machineRes.setMoney(0);
    }
    
    public static void checkSuppliesEspresso(MachineResources machineRes) {
        
        if (machineRes.getWater() >= 250 && machineRes.getBeans() >= 16 && machineRes.getCups() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            machineRes.setWater(machineRes.getWater() - 250);
            machineRes.setBeans(machineRes.getBeans() - 16);
            machineRes.setCups(machineRes.getCups() - 1);
            machineRes.setMoney(machineRes.getMoney() + 4);
        } else if (machineRes.getWater() < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (machineRes.getBeans() < 16) {
            System.out.println("Sorry, not enough beans!"); 
        } else {
            System.out.println("Sorry, not enough cups!");
        }
    }
    
    public static void checkSuppliesLatte(MachineResources machineRes) {
        
        if (machineRes.getWater() >= 350 && machineRes.getMilk() >= 75 && machineRes.getBeans() >= 20 && machineRes.getCups() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            machineRes.setWater(machineRes.getWater() - 350);
            machineRes.setMilk(machineRes.getMilk() - 75);
            machineRes.setBeans(machineRes.getBeans() - 20);
            machineRes.setCups(machineRes.getCups() - 1);
            machineRes.setMoney(machineRes.getMoney() + 7);
        } else if (machineRes.getWater() < 350) {
            System.out.println("Sorry, not enough water!"); 
        } else if (machineRes.getMilk() < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (machineRes.getBeans() < 20) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("Sorry, not enough cups!");
        }
    }
    
    public static void checkSuppliesCappuccino(MachineResources machineRes) {

        if (machineRes.getWater() >= 200 && machineRes.getMilk() >= 100 && machineRes.getBeans() >= 12 && machineRes.getCups() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            machineRes.setWater(machineRes.getWater() - 200);
            machineRes.setMilk(machineRes.getMilk() - 100);
            machineRes.setBeans(machineRes.getBeans() - 12);
            machineRes.setCups(machineRes.getCups() - 1);
            machineRes.setMoney(machineRes.getMoney() + 6);
        } else if (machineRes.getWater() < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (machineRes.getMilk() < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (machineRes.getBeans() < 12) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("Sorry, not enough cups!");
        }
    }
}