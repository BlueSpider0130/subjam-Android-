package com.example.myapplication.ui.listen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

public class ListenFragment extends Fragment {

    private ListenViewModel listenViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listenViewModel =
                new ViewModelProvider(this).get(ListenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_listen, container, false);
//        final TextView textView = root.findViewById(R.id.text_listen);
        listenViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }
}