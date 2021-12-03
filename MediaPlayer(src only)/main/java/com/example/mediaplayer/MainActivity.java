package com.example.mediaplayer;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int starttime = 0 ;
    int stopttime = 0;
    int forwardtime = 5000 ;
    int backwardtime = 5000 ;
    MediaPlayer mediaPlayer,mediaPlayernew;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayernew = MediaPlayer.create(this,R.raw.song);
        Button bt1=findViewById(R.id.play);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing Song",Toast.LENGTH_LONG).show();
                mediaPlayer.start();
            }
        });
        Button bt2=findViewById(R.id.pause);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing Song",Toast.LENGTH_LONG).show();
                mediaPlayer.pause();
            }
        });

        Button bt3=findViewById(R.id.forward);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+forwardtime) <= (stopttime = mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardtime);
                    Toast.makeText(getApplicationContext(), "Song is forwarding",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button bt4=findViewById(R.id.rewind);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+forwardtime) <= (stopttime =
                        mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos-forwardtime);
                    Toast.makeText(getApplicationContext(), "Song is rewinding",Toast.LENGTH_LONG).show();
                }
            }
        });


        Button bt5=findViewById(R.id.stop);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Song is stopped",Toast.LENGTH_LONG).show();
                mediaPlayer.stop();
                mediaPlayer = mediaPlayernew;

            }
        });



        Button bt6=findViewById(R.id.restart);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPlayer.reset();
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });

    }
}
