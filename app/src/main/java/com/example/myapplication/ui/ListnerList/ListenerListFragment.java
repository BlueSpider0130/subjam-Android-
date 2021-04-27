package com.example.myapplication.ui.ListnerList;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListenerListFragment extends Fragment {

    private ListenerListViewModel mViewModel;
    Activity thisFrag = this.getActivity();
    ImageView close_icon;

    public static ListenerListFragment newInstance() {
        return new ListenerListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.listener_list_fragment, container, false);;
        final BottomNavigationView bottom_bar = (BottomNavigationView) this.getActivity().findViewById(R.id.nav_view);
        close_icon = (ImageView) this.getActivity().findViewById(R.id.back_icon);
        String[] listener_name = {"Apple Username", "Banana Username", "Litchi Username", "Mango Username", "PineApple Username", "PineApple Username", "PineApple Username"};//fruit names array
        ArrayList<HashMap<String,Object>> arrayList=new ArrayList<>();
        ListView simpleListView = (ListView)root.findViewById(R.id.listener_list) ;

        for (int i=0;i<listener_name.length;i++){
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("listener_name",listener_name[i]);
            arrayList.add(hashMap);//add the hashmap into arrayList
        }

        String[] from = {"listener_name"};
        int[] to = {R.id.listener_name};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this.getContext(),arrayList,R.layout.listener_list_item,from,to);
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        close_icon.setImageResource(R.drawable.cross);
        close_icon.setVisibility(View.VISIBLE);
        bottom_bar.setVisibility(View.INVISIBLE);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(ListenerListViewModel.class);
        // TODO: Use the ViewModel
    }

}