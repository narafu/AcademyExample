package com.newlecture.app.entity;

import java.util.Date;

public class Lecture {

    private int id;
    private String title;
    private int price;
    private int salePrice;
    private Date regdate;

    public Lecture() {
    }

    public Lecture(int id, String title, int price, int salePrice, Date regdate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.salePrice = salePrice;
        this.regdate = regdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
