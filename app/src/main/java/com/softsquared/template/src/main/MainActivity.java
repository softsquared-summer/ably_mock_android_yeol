package com.softsquared.template.src.main;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.softsquared.template.R;
import com.softsquared.template.src.main.DrawableList.ExpandAdapter;
import com.softsquared.template.src.main.DrawableList.myGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Context context;
    private int groupLayout = 0;
    private int chlidLayout = 0;
    private ArrayList<myGroup> DataList;
    private LayoutInflater myinf = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Drawnavgation ////////////////////////////////////////////////////////////////////////
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view_draw);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        ExpandableListView_initialize();






        /////////////////// Bottom navgation  ////////////////////////////////////
        BottomNavigationView navView = findViewById(R.id.nav_view_bottom);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_style, R.id.navigation_market, R.id.navigation_jjim,R.id.navigation_mypage)
                .build();
        NavController navController_bottom = Navigation.findNavController(this, R.id.nav_host_fragment_bottom);
        NavigationUI.setupActionBarWithNavController(this, navController_bottom, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController_bottom);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    // // // // // // // 확장 리스트뷰 초기화 // // // // //
    public void ExpandableListView_initialize(){

        ArrayList<myGroup> DataList = new ArrayList<myGroup>();
        ExpandableListView listView = (ExpandableListView)findViewById(R.id.mylist);

        myGroup temp = new myGroup("상의");
        temp.child.add("전체");
        temp.child.add("티셔츠");
        temp.child.add("슬리브리스");
        temp.child.add("블라우스/셔츠");
        temp.child.add("니트");
        temp.child.add("맨투맨/후드");
        temp.child.add("베스트");
        DataList.add(temp);
        temp = new myGroup("아우터");
        temp.child.add("전체");
        temp.child.add("가디건");
        temp.child.add("자켓");
        temp.child.add("점퍼");
        temp.child.add("코트");
        temp.child.add("패딩");
        DataList.add(temp);
        temp = new myGroup("원피스");
        temp.child.add("전체");
        temp.child.add("미니원피스");
        temp.child.add("롱원피스");
        temp.child.add("투피스");
        DataList.add(temp);

        temp = new myGroup("팬츠");
        temp.child.add("전체");
        temp.child.add("롱팬츠");
        temp.child.add("숏팬츠");
        temp.child.add("슬렉스");
        temp.child.add("레깅스");
        temp.child.add("점프슈트");
        DataList.add(temp);

        temp = new myGroup("스커트");
        temp.child.add("전체");
        temp.child.add("미니/미디 스커트");
        temp.child.add("롱스커트");
        DataList.add(temp);

        temp = new myGroup("가방");
        temp.child.add("전체");
        temp.child.add("크로스백");
        temp.child.add("숄더백");
        temp.child.add("토트백");
        temp.child.add("클러치");
        temp.child.add("에코백");
        DataList.add(temp);

        temp = new myGroup("신발");
        temp.child.add("전체");
        temp.child.add("플랫/로퍼");
        temp.child.add("힐");
        temp.child.add("스니커즈");
        temp.child.add("샌들");
        temp.child.add("슬리퍼/쪼리");
        temp.child.add("워커/부츠");
        DataList.add(temp);

        temp = new myGroup("패션소품");
        temp.child.add("전체");
        temp.child.add("모자/헤어");
        temp.child.add("양말/스타킹");
        temp.child.add("시계");
        temp.child.add("머플러");
        temp.child.add("폰 악세사리");
        temp.child.add("기타");
        DataList.add(temp);

        temp = new myGroup("주얼리");
        temp.child.add("전체");
        temp.child.add("귀걸이");
        temp.child.add("목걸이");
        temp.child.add("반지");
        temp.child.add("팔찌/발찌");
        DataList.add(temp);

        temp = new myGroup("언더웨어");
        temp.child.add("전체");
        temp.child.add("브라팬티");
        temp.child.add("보정");
        temp.child.add("이너");
        temp.child.add("홈웨어");
        DataList.add(temp);

        temp = new myGroup("비치웨어");
        temp.child.add("전체");
        temp.child.add("비키니");
        temp.child.add("래쉬가드");
        temp.child.add("악세사리");
        DataList.add(temp);

        ///////// 1.1 Drawable 확장 리스트뷰 ////////////////////////////////////////////////////////
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(),R.layout.drawlistview_group_row,R.layout.drawlistview_child_row,DataList);

        listView.setIndicatorBounds(width, width); //이 코드를 지우면 화살표 위치가 바뀐다.
        listView.setVerticalScrollBarEnabled(false);
        listView.setAdapter(adapter);

    }


}
