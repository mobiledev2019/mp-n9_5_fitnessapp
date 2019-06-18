package com.example.fitnesssdemo.Model;

public class Product {
    private String pname, desc, price, image, category, pid, date, time;

    public Product(String pname, String desc, String price, String image) {
        this.pname = pname;
        this.desc = desc;
        this.price = price;
        this.image = image;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
