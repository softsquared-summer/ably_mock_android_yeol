package com.softsquared.template.src.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.softsquared.template.R;
import com.softsquared.template.src.ApplicationClass;
import com.softsquared.template.src.main.bottomnavigation.home.HomeFragment;
import com.softsquared.template.src.main.bottomnavigation.jjim.JjimFragment;
import com.softsquared.template.src.main.bottomnavigation.market.MarketFragment;
import com.softsquared.template.src.main.bottomnavigation.mypage.MypageFragment;
import com.softsquared.template.src.main.bottomnavigation.style.StyleFragment;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment;
    private JjimFragment jjimFragment;
    private MarketFragment marketFragment;
    private StyleFragment styleFragment;
    private MypageFragment mypageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView); //프래그먼트 생성

        homeFragment = new HomeFragment();
        styleFragment = new StyleFragment();
        marketFragment = new MarketFragment();
        jjimFragment = new JjimFragment();
        mypageFragment = new MypageFragment();

        //제일 처음 띄워줄 뷰를 세팅해줍니다. 로그인 유무확인
        if(ApplicationClass.getLoginSuccess())
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, mypageFragment).commitAllowingStateLoss();
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, homeFragment).commitAllowingStateLoss();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, homeFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.navigation_style: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, styleFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.navigation_market: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, marketFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.navigation_jjim: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, jjimFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.navigation_mypage: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, mypageFragment).commitAllowingStateLoss();
                        return true;
                    }

                    default:
                        return false;
                }
            }
        });
    }
}