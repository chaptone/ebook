package com.example.chapmac.ebook.main;

import com.example.chapmac.ebook.data.Book;
import com.example.chapmac.ebook.data.BookStack;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by chapmac on 4/20/2017 AD.
 */

public class BookPresenter implements Observer {
    private BookView view;
    private BookStack repository;

    ArrayList<Book> books;

    public BookPresenter(BookStack repository, BookView view) {
        this.repository = repository;
        this.view = view;
    }

    public void initialize() {
        repository.addObserver(this);
        repository.fetchAllBooks();
    }

    @Override
    public void update(Observable obj, Object arg) {
        if(obj == repository) {
            books = new ArrayList<Book>(repository.getAllBooks());
            view.setBookResult(books);
        }
    }
}