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

        final TextView textView = root.findViewById(R.id.text_broadcast);
        ListView simpleListView = (ListView)root.findViewById(R.id.list_view) ;

        int[] music_action = {R.drawable.music_action, R.drawable.music_action, R.drawable.music_action, R.drawable.music_action, R.drawable.music_action};
        String[] band_name = {"Apple", "Banana", "Litchi", "Mango", "PineApple"};//fruit names array
        String[] title = {"Apple", "Banana", "Litchi", "Mango", "PineApple"};
        String[] description = {"Apple", "Banana", "Litchi", "Mango", "PineApple"};
        int[] listener = {450, 450, 450, 450, 450};
        String[] gen = {"Apple", "Banana", "Litchi", "Mango", "PineApple"};


        ArrayList<HashMap<String,Object>> arrayList=new ArrayList<>();
        for (int i=0;i<band_name.length;i++)
        {
            HashMap<String,Object> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("band_name",band_name[i]);
            hashMap.put("title",title[i]);
            hashMap.put("music_action",music_action[i]+"");
            hashMap.put("description", description[i]);
            hashMap.put("listener", listener[i]);
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"band_name","title","music_action","description","listener"};
        int[] to={R.id.textView,R.id.imageView};


//        broadcastViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}