package com.example.chapmac.ebook.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.chapmac.ebook.R;
import com.example.chapmac.ebook.data.Book;
import com.example.chapmac.ebook.data.BookStack;
import com.example.chapmac.ebook.data.RemoteBookStack;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements BookView {

    BookPresenter presenter;
    ArrayAdapter<Book> bookArrayAdapter;
    private ListView bookListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookStack repository = RemoteBookStack.getInstance();

        bookListView = (ListView) findViewById(R.id.listview_stack);
        bookArrayAdapter = createAdapter(new ArrayList<Book>());
        bookListView.setAdapter(bookArrayAdapter);

        presenter = new BookPresenter(repository, this);
        presenter.initialize();
    }

    @Override
    public void setBookResult(ArrayList<Book> books) {
        bookArrayAdapter = createAdapter(books);
        bookListView.setAdapter(bookArrayAdapter);
    }

    private ArrayAdapter<Book> createAdapter(ArrayList<Book> books) {
        return new ArrayAdapter<Book>(this,
                android.R.layout.simple_list_item_1,
                books);
    }
}
