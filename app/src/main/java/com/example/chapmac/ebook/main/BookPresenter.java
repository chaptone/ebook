package com.example.chapmac.ebook.main;

import com.example.chapmac.ebook.data.Book;
import com.example.chapmac.ebook.data.BookStack;
import com.example.chapmac.ebook.data.RemoteBookStack;
import com.example.chapmac.ebook.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by chapmac on 4/20/2017 AD.
 */

public class BookPresenter implements Observer {
    private BookView view;
    private RemoteBookStack repository;
    private List<Book> books;
    public User user;

    public BookPresenter(BookView view) {
        this.view = view;
    }

    public void initialize() {
        repository = RemoteBookStack.getInstance();
        repository.addObserver(this);
        repository.fetchAllBooks();
    }

    @Override
    public void update(Observable obj, Object arg) {
        if(obj == repository) {
            books = repository.getAllBooks();
            view.setBookResult(books);
        }
    }

    public List<Book> sort(List<Book> books,String state) {
        Book temp;
        if(state.equals("by Published year")){
            for (int i = 0;i<books.size()-1;i++) {
                for (int j = i+1;j<books.size();j++) {
                    if (books.get(i).getPublicationYear() > books.get(j).getPublicationYear()) {
                        temp = books.get(j);
                        books.set(j,books.get(i));
                        books.set(i,temp);
                    }
                }
            }
        } else {
            for (int i = 0;i<books.size()-1;i++) {
                for (int j = i+1;j<books.size();j++) {
                    if (books.get(i).getTitle().charAt(0) > books.get(j).getTitle().charAt(0)) {
                        temp = books.get(j);
                        books.set(j, books.get(i));
                        books.set(i, temp);
                    }
                }
            }

        }

        return books;

    }

    public void search(String text,String state) {
        books = repository.getBooks(text);
        books = sort(books, state);
        view.setBookResult(books);
    }

    public void setMoney(double wallet){
        user.money = wallet;
    }

    public void setTotalPrice(double totalPrice){
        user.order.totalPrice = totalPrice;
    }


    public void addToOrder(int position) {
        user.addToOrder(repository.getBookById(position));
    }
}