package com.example.fitnesssdemo.model;

public class Water {
    private int ID;
    private String total;

    public Water() {
    }

    public Water(String total) {
        this.total = total;
    }

    public Water(int ID, String total) {
        this.ID = ID;
        this.total = total;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Water{" +
                "ID=" + ID +
                ", total=" + total +
                '}';
    }
}
