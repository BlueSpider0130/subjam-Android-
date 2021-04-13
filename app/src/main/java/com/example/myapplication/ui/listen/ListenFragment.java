package com.example.myapplication.ui.listen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.myapplication.LoadingActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.ListenerClient.ListenerClientFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class ListenFragment extends Fragment {

    private ListenViewModel listenViewModel;
    private ImageView before;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listenViewModel =
                new ViewModelProvider(this).get(ListenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_listen, container, false);
        before = (ImageView)this.getActivity().findViewById(R.id. back_icon);
        before.setVisibility(View.INVISIBLE);

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
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                before.setVisibility(View.VISIBLE);
                goto_eachitem(view);
            }
        });

        return root;
    }

    private void goto_eachitem(View view){
        Navigation.findNavController(view).navigate(R.id.listener_client);
    }
}