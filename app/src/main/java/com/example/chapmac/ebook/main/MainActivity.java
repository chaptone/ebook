package com.example.chapmac.ebook.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chapmac.ebook.R;
import com.example.chapmac.ebook.data.Book;

public class MainActivity extends AppCompatActivity implements BookView{

    TextView resultTextView;
    BookPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewHolders();



        if(presenter == null) {
            presenter = new BookPresenter(this);

        }
        presenter.addBook(234, 2, "kuy");
        presenter.addBook(123, 1, "asdasd");
        presenter.addBook(456, 3, "sadasdasd");
        presenter.showList();


        Book b3 = new Book(345, 3, "dasda");
    }

    public void initViewHolders(){
        resultTextView = (TextView) findViewById(R.id.keep);
    }


    public void setBookResult(String result){
        resultTextView.setText(result);

    }
}
