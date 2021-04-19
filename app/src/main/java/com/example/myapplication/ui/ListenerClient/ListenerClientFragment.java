package com.example.myapplication.ui.ListenerClient;

import androidx.lifecycle.ViewModelProvider;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.myapplication.R;

public class ListenerClientFragment extends Fragment {
    public SeekBar seek_bar;
    public ImageView music_play;
    public ImageButton music_stop;
    MediaPlayer player;
    Handler seekHandler = new Handler();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.listener_client_fragment, container, false);
        seek_bar = (SeekBar) root.findViewById(R.id.music_playBar);
        music_play = (ImageButton) root.findViewById(R.id.btn_music_play);
        music_stop = (ImageButton) root.findViewById(R.id.btn_music_stop);

        music_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.start();
                music_play.setVisibility(View.INVISIBLE);
                music_stop.setVisibility(View.VISIBLE);
            }
        });
        music_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();
                music_stop.setVisibility(View.INVISIBLE);
                music_play.setVisibility(View.VISIBLE);
            }
        });

        player = MediaPlayer.create(this.getContext(), R.raw.sample);
        seek_bar.setMax(player.getDuration());
        seekUpdation();

        return root;
    }


    Runnable run = new Runnable(){
        @Override
        public void run(){
            seekUpdation();
        }
    };

    public void seekUpdation(){
        seek_bar.setProgress(player.getCurrentPosition());
        seekHandler.postDelayed(run, 1000);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(ListenerClientViewModel.class);
//        // TODO: Use the ViewModel
//    }

}