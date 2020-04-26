package com.softsquared.template.ui.mypage_bottom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class mypageViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public mypageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}