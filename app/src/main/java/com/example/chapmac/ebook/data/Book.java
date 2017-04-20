package com.example.chapmac.ebook.data;

/**
 * Created by chapmac on 4/20/2017 AD.
 */

public class Book {
    private int price;
    private int id;
    private String title;

    public Book(int price,int id,String title){
        this.price = price;
        this.id = id;
        this.title = title;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
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
    public String toString(){
        return "Title: " + title + " price: " + price;
    }
}
