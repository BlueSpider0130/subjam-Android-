package com.example.myapplication.ui.listen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListenFragment extends Fragment {

    private ListenViewModel listenViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listenViewModel =
                new ViewModelProvider(this).get(ListenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_listen, container, false);

        ListView simpleListView = (ListView)root.findViewById(R.id.list_view) ;

        int[] music_action = {R.drawable.music_action, R.drawable.music_action, R.drawable.music_action, R.drawable.music_action, R.drawable.music_action, R.drawable.logo, R.drawable.logo};
        String[] band_name = {"Apple", "Banana", "Litchi", "Mango", "PineApple", "PineApple", "PineApple"};//fruit names array
        String[] title = {"Apple", "Banana", "Litchi", "Mango", "PineApple", "PineApple", "PineApple"};
        String[] description = {"Apple", "Banana", "Litchi", "Mango", "PineApple", "PineApple", "PineApple"};
        int[] listener = {450, 450, 450, 450, 450, 450, 450};
        String[] gen = {"Apple", "Banana", "Litchi", "Mango", "PineApple", "PineApple", "PineApple"};


        ArrayList<HashMap<String,Object>> arrayList=new ArrayList<>();
        for (int i=0;i<band_name.length;i++)
        {
            HashMap<String,Object> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("band_name",band_name[i]);
            hashMap.put("title",title[i]);
            hashMap.put("music_action",music_action[i]+"");
            hashMap.put("description", description[i]);
            hashMap.put("listener", listener[i]);
            hashMap.put("gen", gen[i]);
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"band_name","title","music_action","description","listener","gen"};
        int[] to={R.id.band_name,R.id.title,R.id.imageView,R.id.description,R.id.listener,R.id.gen};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this.getContext(),arrayList,R.layout.list_view_items,from,to);//Create object and set the parameters for simpleAdapter
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView
//        final TextView textView = root.findViewById(R.id.text_listen);
//        listenViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
////                textView.setText(s);
//            }
//        });
        return root;
    }
}