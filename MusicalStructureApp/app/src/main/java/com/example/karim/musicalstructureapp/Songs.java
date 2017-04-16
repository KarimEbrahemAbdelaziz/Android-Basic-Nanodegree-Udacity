package com.example.karim.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Songs extends AppCompatActivity {

    @BindView(R.id.btnBackToMain)
    Button backToMain;

    @BindView(R.id.btnNextToNowPlaying)
    Button nextToNowPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        ButterKnife.bind(this);

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

        nextToNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Songs.this, NowPlaying.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        backToMain();
    }

    public void backToMain() {
        Intent backToMainIntent = new Intent(Songs.this, MainActivity.class);
        startActivity(backToMainIntent);
        finish();
    }
}
