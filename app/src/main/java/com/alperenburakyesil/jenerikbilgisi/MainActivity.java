package com.alperenburakyesil.jenerikbilgisi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view){
        Intent play_activity = new Intent(MainActivity.this, Level_1.class);

        startActivity(play_activity);
    }

    public void rules(View view){
        Intent rules_activity = new Intent(MainActivity.this, Rules.class);

        startActivity(rules_activity);
    }

    public void about(View view){
        Intent about_activity = new Intent(MainActivity.this, About.class);

        startActivity(about_activity);
    }

    public void exit(View view){
        System.exit(0);
    }
}