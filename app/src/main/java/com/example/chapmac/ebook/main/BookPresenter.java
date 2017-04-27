package com.example.chapmac.ebook.main;

import com.example.chapmac.ebook.data.Book;
import com.example.chapmac.ebook.data.BookStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chapmac on 4/20/2017 AD.
 */

public class BookPresenter {
    private BookView view;
    private BookStack bookstack;
    private ArrayList<Book> bookShelf;

    public BookPresenter(BookStack bookstack, BookView view){
        this.bookShelf = new ArrayList<Book>();
        this.view = view;
    }

    public void addBook(int price, int id, String title){
        bookShelf.add(new Book(price,id,title));
        bookstack.addStack(new Book(price,id,title));
    }

    public void showList(){
        String tmp = "";

        if(bookShelf.isEmpty()){
            tmp = "No Book";
        }else {
            for (Book i : bookShelf) {
                tmp += i.toString() + "\n";


            }
        }
        view.setBookResult(tmp);

    }



}
