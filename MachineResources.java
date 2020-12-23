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
