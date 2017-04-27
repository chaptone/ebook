package com.example.chapmac.ebook.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 4/27/2017.
 */

public class MockBookStack extends BookStack {
    private List<Book> books;
    private static MockBookStack instance = null;

    public static MockBookStack getInstance() {
        if(instance == null) {
            instance = new MockBookStack();
        }
        return instance;
    }

    private MockBookStack() {
        books = new ArrayList<Book>();
        books.add(new Book(1,"Introduction to Java",13.95,2015));
        books.add(new Book(10,"Introduction to C++",19.95,2016));
        books.add(new Book(12,"Algorithms",29.95,2012));
        books.add(new Book(17,"Pascal Programming",17.95,2007));
    }

    @Override
    public void fetchAllBooks() {
        setChanged();
        notifyObservers();
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}
