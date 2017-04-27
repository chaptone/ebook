package com.example.chapmac.ebook.data;

/**
 * Created by Max on 26/4/2560.
 */

public class Book {
    private int id;
    private String title;
    private double price;
    private int publicationYear;
    private String imageUrl;

    public Book(int id, String title, double price, int publicationYear) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.publicationYear = publicationYear;
        this.imageUrl = null;
    }

    public String toString() {
        return title + " (" + price + ")";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
