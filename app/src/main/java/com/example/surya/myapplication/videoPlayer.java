package com.example.surya.myapplication;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

/**
 * Created by surya on 6/7/17.
 */

public class videoPlayer extends AppCompatActivity {
    ProgressDialog pDialog;
    VideoView video;
    //ImageButton play;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        video = (VideoView) findViewById(R.id.video);
        String VideoURL = "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4";

        Uri vidUri = Uri.parse(VideoURL);
        video.setVideoURI(vidUri);
        MediaController vidControl = new MediaController(this);
        //vidControl.setVisibility(View.GONE);
        vidControl.setAnchorView(video);
        video.setMediaController(vidControl);
        video.start();


    }


}