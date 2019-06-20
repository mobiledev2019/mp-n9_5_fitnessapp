package com.example.fitnesssdemo.model;

public class Food {
    private int ID;
    private String rice;
    private String beef;
    private String pork;
    private String fish;
    private String chicken;
    private String vegetable;
    private String total;

    public Food() {
    }

    public Food(String rice, String beef, String pork, String fish, String chicken, String vegetable, String total) {
        this.rice = rice;
        this.beef = beef;
        this.pork = pork;
        this.fish = fish;
        this.chicken = chicken;
        this.vegetable = vegetable;
        this.total = total;
    }

    public Food(int ID, String rice, String beef, String pork, String fish, String chicken, String vegetable, String total) {
        this.ID = ID;
        this.rice = rice;
        this.beef = beef;
        this.pork = pork;
        this.fish = fish;
        this.chicken = chicken;
        this.vegetable = vegetable;
        this.total = total;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRice() {
        return rice;
    }

    public void setRice(String rice) {
        this.rice = rice;
    }

    public String getBeef() {
        return beef;
    }

    public void setBeef(String beef) {
        this.beef = beef;
    }

    public String getPork() {
        return pork;
    }

    public void setPork(String pork) {
        this.pork = pork;
    }

    public String getFish() {
        return fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    public String getChicken() {
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Food{" +
                "ID=" + ID +
                ", rice=" + rice +
                ", beef=" + beef +
                ", pork=" + pork +
                ", fish=" + fish +
                ", chicken=" + chicken +
                ", vegetable=" + vegetable +
                ", total=" + total +
                '}';
    }
}
