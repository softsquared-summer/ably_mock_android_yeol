package com.softsquared.template.ui.jjim_bottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.softsquared.template.R;


public class jjimFragment extends Fragment {

    private jjimViewModel jjimViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        jjimViewModel =
                ViewModelProviders.of(this).get(jjimViewModel.class);
        View root = inflater.inflate(R.layout.fragment_jjim_bottom, container, false);
        final TextView textView = root.findViewById(R.id.text_jjim);
        jjimViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
