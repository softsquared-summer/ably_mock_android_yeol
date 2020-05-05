package com.softsquared.template.src.main.bottomnavigation.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.softsquared.template.R;
import com.softsquared.template.src.ApplicationClass;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.SigninActivity;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.SignCheckActivity;

public class MypageFragment extends Fragment {

    private ViewGroup viewGroup;
    private ApplicationClass applicationClass;
    private ImageView mypageInfor;
    private Button signButton;
    private Button signQuickButton;
    private TextView navheadtext;
    private TextView navheadtext2;
    private TextView navheadtext3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragmnet_mypage, container, false);

         signButton = viewGroup.findViewById(R.id.sign_button);
        mypageInfor =  viewGroup.findViewById(R.id.mypage_information);
        navheadtext =  viewGroup.findViewById(R.id.navheader_text);
        navheadtext2 =  viewGroup.findViewById(R.id.navheader_text2);
        navheadtext3 =  viewGroup.findViewById(R.id.navheader_text3);



        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSingin = new Intent(getActivity(), SigninActivity.class);
                startActivity(intentSingin);
            }
        });

        signQuickButton = viewGroup.findViewById(R.id.sign_quickButton);
        signQuickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignCehck = new Intent(getActivity(), SignCheckActivity.class);
                startActivity(intentSignCehck);
            }
        });


        return viewGroup;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (applicationClass.loginSuccess){
            mypageInfor.setVisibility(viewGroup.VISIBLE);
            navheadtext.setVisibility(viewGroup.GONE);
            navheadtext2.setVisibility(viewGroup.GONE);
            navheadtext3.setVisibility(viewGroup.GONE);

            signButton.setVisibility(viewGroup.GONE);
            signQuickButton.setVisibility(viewGroup.GONE);
        }else{
            mypageInfor.setVisibility(viewGroup.GONE);
        }

    }
}
