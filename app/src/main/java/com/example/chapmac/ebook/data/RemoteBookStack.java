package com.example.chapmac.ebook.data;

import android.os.AsyncTask;

import com.example.chapmac.ebook.utils.UrlFetcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 27/4/2560.
 */

public class RemoteBookStack extends BookStack {
    private List<Book> books;

    private static RemoteBookStack instance = null;

    public static RemoteBookStack getInstance() {
        if(instance == null) {
            instance = new RemoteBookStack();
        }
        return instance;
    }

    private RemoteBookStack() {
        books = new ArrayList<Book>();
    }

    @Override
    public void fetchAllBooks() {
        BookFetcherTask task = new BookFetcherTask();
        task.execute();
    }

    public List<Book> getBooks(String text) {
        List<Book> result = new ArrayList<Book>();
        for(Book b:books) {
            if (b.toString().contains(text)) result.add(b);
        }
        return result;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    public class BookFetcherTask extends AsyncTask<Void,Void,ArrayList<Book>> {
        @Override
        protected ArrayList<Book> doInBackground(Void... params) {
            String bookListJsonStr = loadJSON();
            if(bookListJsonStr != null) {
                return com.example.chapmac.ebook.data.decoders.BookJSONDecoder.createListFromJSONStr(bookListJsonStr);
            } else {
                return null;
            }
        }

        private String loadJSON() {
            URL booksURL = null;
            try {
                booksURL = new URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return (new UrlFetcher(booksURL)).fetch();
        }

        @Override
        protected void onPostExecute(ArrayList<Book> results) {
            if(results != null) {
                books.clear();
                books.addAll(results);
                setChanged();
                notifyObservers();
            }
        }
    }

    public Book getBookById(int position){
        return books.get(position);
    }
}
