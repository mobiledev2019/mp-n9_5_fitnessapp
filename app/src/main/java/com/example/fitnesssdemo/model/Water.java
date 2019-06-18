package com.example.fitnesssdemo.model;

public class Water {
    private int ID;
    private String values;

    public Water() {
    }

    public Water(String values) {
        this.values = values;
    }

    public Water(int ID, String values) {
        this.ID = ID;
        this.values = values;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Water{" +
                "ID=" + ID +
                ", values='" + values + '\'' +
                '}';
    }
}
