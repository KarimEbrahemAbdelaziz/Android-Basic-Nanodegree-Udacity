package com.example.karim.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Albums extends AppCompatActivity{

    @BindView(R.id.btnBackToMain)
    Button backToMain;

    @BindView(R.id.btnNextToSongs)
    Button nextToSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        ButterKnife.bind(this);

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

        nextToSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSongs = new Intent(Albums.this, Songs.class);
                startActivity(goToSongs);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        backToMain();
    }

    public void backToMain() {
        Intent backToMainIntent = new Intent(Albums.this, MainActivity.class);
        startActivity(backToMainIntent);
        finish();
    }
}
