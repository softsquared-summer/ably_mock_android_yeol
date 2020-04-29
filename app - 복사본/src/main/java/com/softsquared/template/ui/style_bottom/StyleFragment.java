package com.softsquared.template.ui.style_bottom;

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

public class StyleFragment extends Fragment {

    private StyleViewModel styleViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        styleViewModel =
                ViewModelProviders.of(this).get(StyleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_style_bottom, container, false);
        final TextView textView = root.findViewById(R.id.text_style);
        styleViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
