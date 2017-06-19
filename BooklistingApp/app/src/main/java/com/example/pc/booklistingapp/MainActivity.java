package com.example.pc.booklistingapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Book>>{
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.btn_search)
    Button mSearchButton;
    @BindView(R.id.text_view_information)
    TextView mInfoTextView;
    @BindView(R.id.edit_text_search)
    EditText mSearchEditText;

    static String searchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new BookAdapter(new ArrayList<Book>(), new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
            }
        });

        mRecyclerView.setAdapter(mAdapter);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {
                    searchData = mSearchEditText.getText().toString();
                    if(searchData.isEmpty()){
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.empty_search), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    getSupportLoaderManager().initLoader(1, null, MainActivity.this).forceLoad();
                } else {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public Loader<ArrayList<Book>> onCreateLoader(int id, Bundle args) {
        return new BookLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Book>> loader, ArrayList<Book> bookData) {
        if (bookData == null) {
            mAdapter = new BookAdapter(new ArrayList<Book>(), new BookAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Book book) {
                }
            });
            Toast.makeText(MainActivity.this, getResources().getString(R.string.no_data_found), Toast.LENGTH_SHORT).show();
            mRecyclerView.setAdapter(mAdapter);
            mInfoTextView.setVisibility(View.VISIBLE);
            return;
        }
        mAdapter = new BookAdapter(bookData, new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
                String url = book.getBookInfoLink();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mInfoTextView.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Book>> loader) {
        mAdapter = new BookAdapter(new ArrayList<Book>(), new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mInfoTextView.setVisibility(View.VISIBLE);
    }
}
