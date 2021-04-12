package com.example.myapplication.ui.listen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ListenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is listen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}