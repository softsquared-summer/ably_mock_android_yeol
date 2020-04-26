package com.softsquared.template.ui.jjim_bottom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class jjimViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public jjimViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}