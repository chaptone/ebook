package com.example.chapmac.ebook.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chapmac.ebook.R;
import com.example.chapmac.ebook.data.Book;
import com.example.chapmac.ebook.data.BookStack;

public class MainActivity extends AppCompatActivity implements BookView{

    private BookStack bookstack;
    private BookPresenter presenter = null;
    private ArrayAdapter<Book> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(presenter == null) {
            bookstack = new BookStack();
            presenter = new BookPresenter(bookstack, this);
        }
        presenter.addBook(234, 2, "kuy");
        presenter.addBook(123, 1, "asdasd");
        presenter.addBook(456, 3, "sadasdasd");

        setUpListView();
        notifyAdapter();
    }

    private void setUpListView(){
        ListView listView = (ListView) findViewById(R.id.listview_stack);

        listAdapter = new ArrayAdapter<Book>(this,
                R.layout.item_gamestack_number,
                R.id.textview_gamestack_number,
                bookstack.getBookArrayList());

        listView.setAdapter(listAdapter);
    }

    public void notifyAdapter(){
        listAdapter.notifyDataSetChanged();
    }
}
