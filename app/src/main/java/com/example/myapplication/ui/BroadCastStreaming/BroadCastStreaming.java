package com.example.myapplication.ui.BroadCastStreaming;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BroadCastStreaming extends Fragment {

    private BroadCastStreamingViewModel mViewModel;
    public View root;
    ImageView before;
    int flag;

    public static BroadCastStreaming newInstance() {
        return new BroadCastStreaming();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final BottomNavigationView bottom_bar = (BottomNavigationView) this.getActivity().findViewById(R.id.nav_view);

        root = inflater.inflate(R.layout.broad_cast_streaming_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(BroadCastStreamingViewModel.class);
        mViewModel.setFlag();

        bottom_bar.setVisibility(View.VISIBLE);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button play_pause = (Button) root.findViewById(R.id.pause_button);
        TextView setDialog = (TextView) root.findViewById(R.id.end_broadcast);
        before = (ImageView) this.getActivity().findViewById(R.id.back_icon);
        ImageButton setting = (ImageButton) root.findViewById(R.id.settingButton);
        flag = ((Button) root.findViewById(R.id.pause_button)).getText().length();
        TextView listeners_list = (TextView) root.findViewById(R.id.TextView1);

        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        setDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(before);
            }
        });
        listeners_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.listener_list);
            }
        });

        // TODO: Use the ViewModel

    }

    public void play(){
        if (flag == 15){
            TextView status = (TextView)root.findViewById(R.id.textView_play);
            Button play_btn = (Button) root.findViewById(R.id.pause_button);
            play_btn.setText("PLAY BROADCAST");
            status.setText("BROADCAST PAUSED");
            status.setBackgroundColor(Color.parseColor("#f7b600"));
            flag = 14;
        }else if (flag != 15){
            TextView status = (TextView)root.findViewById(R.id.textView_play);
            Button play_btn = (Button) root.findViewById(R.id.pause_button);
            play_btn.setText("PAUSE BROADCAST");
            status.setText("LIVESTREAMING BROADCAST");
            status.setBackgroundColor(Color.parseColor("#6dd500"));
            flag = 15;
        }
    }
    public void dialog(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.modal);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView cross_close = (ImageView) dialog.findViewById(R.id.cross);
        TextView cancel = (TextView) dialog.findViewById(R.id.cancel_broadcast);
        Button end_broadcast = (Button) dialog.findViewById(R.id.end_button);

        cross_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        end_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                end();
            }
        });

        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }

    public void end() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.thanks_modal);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView cross_close = (ImageView) dialog.findViewById(R.id.cross);
        Button end_broadcast = (Button) dialog.findViewById(R.id.end_button);

        cross_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        end_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Navigation.findNavController(root).navigate(R.id.navigation_listen);
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }

    public void set(ImageView before) {
        before.setVisibility(View.VISIBLE);
        Navigation.findNavController(root).navigate(R.id.metadata_form);
    }

}