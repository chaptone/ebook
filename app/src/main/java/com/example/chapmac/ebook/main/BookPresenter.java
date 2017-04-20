package com.example.chapmac.ebook.main;

import com.example.chapmac.ebook.data.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chapmac on 4/20/2017 AD.
 */

public class BookPresenter {
    private BookView view;
    private List<Book> bookShelf;

    public BookPresenter(BookView view){
        this.bookShelf = new ArrayList<Book>();
        this.view = view;
    }

    public void addBook(int price, int id, String title){
        bookShelf.add(new Book(price,id,title));
    }

    public void showList(){
        String tmp = "";
        for(Book i : bookShelf){
            tmp += i.toString()+"\n";


        }
        view.setBookResult(tmp);

    }

}
