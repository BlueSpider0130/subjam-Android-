package com.example.myapplication.ui.Password;

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
import android.widget.TextView;

import com.example.myapplication.R;

public class PasswordFragment extends Fragment {

    private PasswordViewModel mViewModel;
    View root;

    public static PasswordFragment newInstance() {
        return new PasswordFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.password_fragment, container, false);
        Button save = (Button) root.findViewById(R.id.save_button);
        TextView cancel = (TextView) root.findViewById(R.id.cancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavePass();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cancel();
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PasswordViewModel.class);
        // TODO: Use the ViewModel
    }

    public void SavePass(){
        Navigation.findNavController(root).navigate(R.id.edit_profile);
    }

    public void Cancel() {
        Navigation.findNavController(root).navigate(R.id.edit_profile);
    }

}