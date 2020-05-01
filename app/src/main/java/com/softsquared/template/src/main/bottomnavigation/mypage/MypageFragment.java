package com.softsquared.template.src.main.bottomnavigation.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.SigninActivity;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.SignCheckActivity;

public class MypageFragment extends Fragment {
    ViewGroup viewGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragmnet_mypage, container, false);

        Button signButton = viewGroup.findViewById(R.id.sign_button);
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSingin = new Intent(getActivity(), SigninActivity.class);
                startActivity(intentSingin);
            }
        });

        Button signQuickButton = viewGroup.findViewById(R.id.sign_quickButton);
        signQuickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignCehck = new Intent(getActivity(), SignCheckActivity.class);
                startActivity(intentSignCehck);
            }
        });


        return viewGroup;
    }
}
