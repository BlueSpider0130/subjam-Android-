package com.example.myapplication.ui.Follow;

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
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FollowBandProfileFragment extends Fragment {

    private FollowBandProfileViewModel mViewModel;
    public View root;

    public static FollowBandProfileFragment newInstance() {
        return new FollowBandProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.follow_band_profile_fragment, container, false);

        ImageView back = this.getActivity().findViewById(R.id.back_icon);
        final BottomNavigationView bottom_bar = (BottomNavigationView) this.getActivity().findViewById(R.id.nav_view);
        bottom_bar.setVisibility(View.VISIBLE);
        back.setImageResource(R.drawable.back_icon);
        back.setVisibility(View.VISIBLE);
        TextView follow_list = (TextView) root.findViewById(R.id.TextView1);
        final Button follow = (Button) root.findViewById(R.id.follow_button);

        follow_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.listener_list);
            }
        });

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (follow.getText() == "FOLLOWING"){
                    follow.setText("FOLLOW");
                } else follow.setText("FOLLOWING");
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FollowBandProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}