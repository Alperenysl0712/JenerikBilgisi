package com.alperenburakyesil.jenerikbilgisi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.logging.Level;

public class Level_2 extends AppCompatActivity {

    private TextView message;
    private TextView time;
    private Intent activity;
    private MediaPlayer mysong;
    private int chance = 2;
    private int playBut = 0;
    private int currentProgress = 0;
    private Button playPauseButton;
    private CountDownTimer countDownTimer;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        message = findViewById(R.id.answer);
        time = findViewById(R.id.time);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        playPauseButton = (Button) findViewById(R.id.playPauseButton);

        playMusic();
    }

    public void secondWrong(){
        message.setText("Bilemediniz --> Cevap: (Olacak O Kadar)");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity = new Intent(Level_2.this, Level_3.class);
                cancelTimer();
                startActivity(activity);
                finish();
            }
        }, 1000);
    }

    public void playMusic(){
        if (playBut == 0){
            playBut = 1;
            mysong = MediaPlayer.create(Level_2.this, R.raw.level2_ook);
            mysong.start();
            startTimer();
            playPauseButton.setBackgroundResource(R.drawable.pause);
        }

        else {
            playBut = 0;
            cancelTimer();
            playPauseButton.setBackgroundResource(R.drawable.play);
        }
    }

    void startTimer() {
        countDownTimer = new CountDownTimer(11000, 1000) {
            public void onTick(long millisUntilFinished) {
                time.setText("00:" + String.valueOf(millisUntilFinished/1000));
                currentProgress = currentProgress + 1;
                progressBar.setProgress(currentProgress);
                progressBar.setMax(11);
            }
            public void onFinish() {
                playPauseButton.setBackgroundResource(R.drawable.play);
                time.setText("00:00");
                playBut = 0;
                currentProgress = 0;
                progressBar.setProgress(currentProgress);

            }
        };
        countDownTimer.start();
    }


    //cancel timer
    void cancelTimer() {
        if(countDownTimer!=null){
            countDownTimer.cancel();
            mysong.stop();
            time.setText("00:00");
            currentProgress = 0;
            progressBar.setProgress(currentProgress);
        }

    }

    public void playPause(View view){
        playMusic();
    }

    public void first(View view){
        if (chance == 2){
            message.setText("Yanlış Cevap");
            chance--;
        }
        else {
            secondWrong();

        }

    }

    public void second(View view){
        if (chance == 2){
            message.setText("Yanlış Cevap");
            chance--;
        }
        else {
            secondWrong();
        }
    }

    public void third(View view){
        if (chance == 2){
            message.setText("Yanlış Cevap");
            chance--;
        }
        else {
            secondWrong();

        }
    }

    public void fourth(View view){

        message.setText("Doğru Cevap (Olacak O Kadar)");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity = new Intent(Level_2.this, Level_3.class);
                cancelTimer();
                startActivity(activity);
                finish();
            }
        }, 1000);
    }
}