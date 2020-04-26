package com.softsquared.template.ui.market_bottom;

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


public class marketFragment extends Fragment {

    private marketViewModel MarketViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MarketViewModel =
                ViewModelProviders.of(this).get(marketViewModel.class);
        View root = inflater.inflate(R.layout.fragment_market_bottom, container, false);
        final TextView textView = root.findViewById(R.id.text_market);
        MarketViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
