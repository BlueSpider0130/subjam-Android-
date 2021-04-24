package com.example.myapplication.ui.broadcast;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.ui.BroadCastStreaming.BroadCastStreamingViewModel;
import com.example.myapplication.ui.metadata.MetadataForm;

import java.util.ArrayList;
import java.util.HashMap;

public class BroadcastFragment extends Fragment {

    private BroadcastViewModel broadcastViewModel;
    private BroadCastStreamingViewModel broadCastStreamingViewModel;
    public View root;
    int checkBoxVisible = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        broadcastViewModel =
                new ViewModelProvider(this).get(BroadcastViewModel.class);
        broadCastStreamingViewModel = new ViewModelProvider(getActivity()).get(BroadCastStreamingViewModel.class);
        broadCastStreamingViewModel.setDefault();
        root = inflater.inflate(R.layout.fragment_broadcast, container, false);

        ImageView checkBox = (ImageView) root.findViewById(R.id.checkbox_imageView);
        TextView checkText = (TextView) root.findViewById(R.id.textView_check);
        ImageView before = (ImageView) this.getActivity().findViewById(R.id.back_icon);

        before.setVisibility(View.INVISIBLE);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        checkText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        Button btn_contin = (Button) root.findViewById(R.id.continue_button);
        btn_contin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_form(root);
            }
        });

        return root;
    }

    public void check() {
        ImageView tick = (ImageView) root.findViewById(R.id.tick_imageView);
        Button btn_contin = (Button) root.findViewById(R.id.continue_button);
        if (checkBoxVisible == 0){
            tick.setVisibility(View.INVISIBLE);
            btn_contin.setVisibility(View.INVISIBLE);
            checkBoxVisible = 1;
        }else if (checkBoxVisible == 1){
            tick.setVisibility(View.VISIBLE);
            btn_contin.setVisibility(View.VISIBLE);
            checkBoxVisible = 0;
        }
    }
    public void goto_form(View view){
        Navigation.findNavController(view).navigate(R.id.metadata_form);
    }

}