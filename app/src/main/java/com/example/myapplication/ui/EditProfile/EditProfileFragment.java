package com.example.myapplication.ui.EditProfile;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class EditProfileFragment extends Fragment {

    private EditProfileViewModel mViewModel;
    private View root;
    private int checkBoxVisible =1;
    Activity thisAct = this.getActivity();

    public static EditProfileFragment newInstance() {
        return new EditProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.edit_profile_fragment, container, false);
        ImageView back = this.getActivity().findViewById(R.id.back_icon);
        back.setVisibility(View.VISIBLE);

        ImageView checkbox = (ImageView) root.findViewById(R.id.checkbox_imageView);
        TextView checktext = (TextView) root.findViewById(R.id.textView_check);
        Button save_button = (Button) root.findViewById(R.id.save_button);
        TextView cancel_edit = (TextView) root.findViewById(R.id.cancel_edit);
        TextView password = (TextView) root.findViewById(R.id.editTextPassword);

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
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.navigation_profile);
            }
        });
        cancel_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.navigation_profile);
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                thisAct.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                Navigation.findNavController(root).navigate(R.id.password);
            }
        });
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.navigation_profile);
//            }
//        });

        return root;
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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EditProfileViewModel.class);
        // TODO: Use the ViewModel
    }


}