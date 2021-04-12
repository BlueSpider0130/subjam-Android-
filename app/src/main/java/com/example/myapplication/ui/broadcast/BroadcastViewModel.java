package com.example.myapplication.ui.broadcast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BroadcastViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BroadcastViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is broadcast fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}