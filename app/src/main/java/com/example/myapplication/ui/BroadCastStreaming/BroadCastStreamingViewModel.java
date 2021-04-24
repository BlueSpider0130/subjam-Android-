package com.example.myapplication.ui.BroadCastStreaming;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class BroadCastStreamingViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Integer> mText;

    static public int flag = 0;
    public BroadCastStreamingViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue(1);
    }
    public int getFlag(){
        return flag;
    }

    public void setFlag(){
        flag = 1;
    }

    public void setDefault() {
        flag = 0;
    }
}