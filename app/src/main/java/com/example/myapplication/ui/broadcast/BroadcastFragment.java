package com.example.myapplication.ui.broadcast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class BroadcastFragment extends Fragment {

    private BroadcastViewModel broadcastViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        broadcastViewModel =
                new ViewModelProvider(this).get(BroadcastViewModel.class);
        View root = inflater.inflate(R.layout.fragment_broadcast, container, false);

//        final TextView textView = root.findViewById(R.id.text_broadcast);


//        broadcastViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}