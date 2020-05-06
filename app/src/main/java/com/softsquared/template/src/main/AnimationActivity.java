package com.softsquared.template.src.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.softsquared.template.R;
import com.softsquared.template.src.ApplicationClass;
import com.softsquared.template.src.main.bottomnavigation.home.HomeFragment;
import com.softsquared.template.src.main.bottomnavigation.jjim.JjimFragment;
import com.softsquared.template.src.main.bottomnavigation.market.MarketFragment;
import com.softsquared.template.src.main.bottomnavigation.mypage.MypageFragment;
import com.softsquared.template.src.main.bottomnavigation.style.StyleFragment;

public class AnimationActivity extends AppCompatActivity {

    private Animation alphaAni;
    private Animation alphaAniSlow;
    private TextView textTop;
    private TextView textDown;
    private TextView textDonw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        TextView textTop =  findViewById(R.id.Text_top);
        final TextView textDown =  findViewById(R.id.Text_down1);
        final TextView textDown2 =  findViewById(R.id.Text_down2);

        textDown.setVisibility(View.GONE);
        textDown2.setVisibility(View.GONE);
        alphaAniSlow = AnimationUtils.loadAnimation(this, R.anim.slide_up_slow);
        alphaAni = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        textTop.startAnimation(alphaAniSlow);

        // 이미지 애니메이션
        Handler mHandlerImage = new Handler();
        mHandlerImage.postDelayed(new Runnable()  {
            public void run() {
                textDown.setVisibility(View.VISIBLE);
                textDown2.setVisibility(View.VISIBLE);
                textDown.startAnimation(alphaAni);
                textDown2.startAnimation(alphaAni);
            }
        }, 1000); //1 초후

        // 액티비티 전환
        Handler mHandlerActivity = new Handler();
        mHandlerActivity.postDelayed(new Runnable()  {
            public void run() {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        }, 4000); // 4초 후




    }
}