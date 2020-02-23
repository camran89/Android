package com.example.volumeseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    MediaPlayer myPlayer;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPlayer=MediaPlayer.create(MainActivity.this,R.raw.audio);
        myPlayer.start();

        audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar seekBar=(SeekBar) findViewById(R.id.seekBar);

        final SeekBar scrubber= (SeekBar) findViewById(R.id.mySeekBar);
        scrubber.setMax(myPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubber.setProgress(myPlayer.getCurrentPosition());
            }
        },0,1000);



        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                myPlayer.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                myPlayer.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                myPlayer.start();

            }
        });

         seekBar.setMax(maxVolume);
         seekBar.setProgress(curVolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}
