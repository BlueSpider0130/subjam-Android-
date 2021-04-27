package com.example.myapplication.ui.profile;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        final BottomNavigationView bottom_bar = (BottomNavigationView) this.getActivity().findViewById(R.id.nav_view);

        final ImageView before = (ImageView) this.getActivity().findViewById(R.id.back_icon);
        before.setVisibility(View.INVISIBLE);
        before.setImageResource(R.drawable.back_icon);
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView follower = (TextView) root.findViewById(R.id.TextView1);
        ImageView edit_profile = (ImageView) root.findViewById(R.id.settingButton);

        bottom_bar.setVisibility(View.VISIBLE);

        follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                before.setVisibility(View.VISIBLE);
                Navigation.findNavController(v).navigate(R.id.listener_list);
            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.edit_profile);
            }
        });

        return root;
    }
}