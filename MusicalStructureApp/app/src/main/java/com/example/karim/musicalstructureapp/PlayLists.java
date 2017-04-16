package com.example.karim.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayLists extends AppCompatActivity{

    @BindView(R.id.btnBackToMain)
    Button backToMain;

    @BindView(R.id.btnNextToSongs)
    Button nextToSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_lists);
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
                Intent goToSongs = new Intent(PlayLists.this, Songs.class);
                startActivity(goToSongs);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed(){
        backToMain();
    }

    public void backToMain() {
        Intent backToMainIntent = new Intent(PlayLists.this, MainActivity.class);
        startActivity(backToMainIntent);
        finish();
    }
}
