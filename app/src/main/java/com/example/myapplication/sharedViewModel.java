package com.example.myapplication;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class sharedViewModel extends ViewModel {
    private final SavedStateHandle state;
    private final MutableLiveData<String> messageContainerA;
    private final MutableLiveData<String> messageContainerB;

    public sharedViewModel(SavedStateHandle state) {
        this.state = state;

        messageContainerA = state.getLiveData("Default Message");
        messageContainerB = state.getLiveData("Default Message");
    }

    public void sendMessageToB(String msg)
    {
        messageContainerB.setValue(msg);
    }
    public void sendMessageToA(String msg)
    {
        messageContainerA.setValue(msg);

    }
    public LiveData<String> getMessageContainerA() {
        return messageContainerA;
    }

    public LiveData<String> getMessageContainerB() {
        return messageContainerB;
    }
}
