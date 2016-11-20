package com.example.students.test;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayProgressBar extends AppCompatActivity {
    Button clk;
    VideoView videov;
    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_progress_bar);
        clk = (Button) findViewById(R.id.button);
        videov = (VideoView) findViewById(R.id.videoView);
        mediaC = new MediaController(this);
    }

public void videoplay(View v)
{
    String videopath = "android.resource://com.example.students.test/"+R.raw.hillz;
    Uri uri = Uri.parse(videopath);
    videov.setVideoURI(uri);
    videov.setMediaController(mediaC);
    mediaC.setAnchorView(videov);
    videov.start();
}
}
