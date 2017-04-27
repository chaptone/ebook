package com.example.chapmac.ebook.data;

import java.util.List;
import java.util.Observable;

/**
 * Created by Max on 4/27/2017.
 */

public abstract class BookStack extends Observable{
    public abstract void fetchAllBooks();
    public abstract List<Book> getAllBooks();
}
