package com.example.myapplication.ui.metadata;

import androidx.lifecycle.Observer;
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
import com.example.myapplication.ui.BroadCastStreaming.BroadCastStreamingViewModel;
import com.example.myapplication.ui.broadcast.BroadcastViewModel;

public class MetadataForm extends Fragment {
    public View root;
    int checkBoxVisible = 1;
    int edit_flag;

    private MetadataFormViewModel mViewModel;
    private BroadCastStreamingViewModel nViewModel;

    public static MetadataForm newInstance() {
        return new MetadataForm();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.metadata_form_fragment, container, false);

        mViewModel = new ViewModelProvider(this).get(MetadataFormViewModel.class);
        nViewModel = new ViewModelProvider(getActivity()).get(BroadCastStreamingViewModel.class);

        ImageView checkbox = (ImageView) root.findViewById(R.id.checkbox_imageView);
        TextView checktext = (TextView) root.findViewById(R.id.textView_check);
        final Button golive = (Button) root.findViewById(R.id.golive_button);
        TextView cancel = (TextView) root.findViewById(R.id.cancel_edit);

        // TODO: Use the ViewModel
        if (nViewModel.getFlag() == 1){
            golive.setText("SAVE");
            cancel.setVisibility(View.VISIBLE);
        }

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
        cancel.setOnClickListener(new View.OnClickListener() {
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