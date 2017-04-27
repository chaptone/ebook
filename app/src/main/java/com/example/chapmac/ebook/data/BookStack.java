package com.example.chapmac.ebook.data;

import java.util.ArrayList;

/**
 * Created by chapmac on 4/20/2017 AD.
 */

public class BookStack {

    private ArrayList<Book> bookStack;

    public BookStack(){
        bookStack = new ArrayList<Book>();
    }

    public void addStack(Book book){
        bookStack.add(book);
    }


    public ArrayList<Book> getBookArrayList() {
        return bookStack;
    }

    public String toString() {
        String tmp = "";

        if(bookStack.isEmpty()){
            tmp = "No Book";
        }else {
            for (Book i : bookStack) {
                tmp += i.toString() + "\n";


            }
        }
        return tmp;
    }
}
