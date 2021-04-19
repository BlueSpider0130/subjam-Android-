package com.example.myapplication.ui.metadata;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class MetadataForm extends Fragment {
    public View root;
    int checkBoxVisible = 1;

    private MetadataFormViewModel mViewModel;

    public static MetadataForm newInstance() {
        return new MetadataForm();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.metadata_form_fragment, container, false);

        ImageView checkbox = (ImageView) root.findViewById(R.id.checkbox_imageView);
        TextView checktext = (TextView) root.findViewById(R.id.textView_check);
        Button golive = (Button) root.findViewById(R.id.golive_button);

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        checktext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        golive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golive(root);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MetadataFormViewModel.class);
        // TODO: Use the ViewModel
    }


    public void check() {
        ImageView tick = (ImageView)root.findViewById(R.id.tick_imageView);
        if (checkBoxVisible == 0){
            tick.setVisibility(View.INVISIBLE);
            checkBoxVisible = 1;
        }else if (checkBoxVisible == 1){
            tick.setVisibility(View.VISIBLE);
            checkBoxVisible = 0;
        }
    }

    public void golive(View view){
        Navigation.findNavController(view).navigate(R.id.broadcast_streaming);
    }

}