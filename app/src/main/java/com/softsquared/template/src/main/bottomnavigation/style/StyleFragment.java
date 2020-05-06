package com.softsquared.template.src.main.bottomnavigation.style;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.style.fragment.MainViewAdapter;

import com.softsquared.template.src.main.bottomnavigation.style.fragment.StyleRecyclerItem;

import java.util.ArrayList;

public class StyleFragment extends Fragment {

        private SwipeRefreshLayout swipeToRefresh;
        private RecyclerView recyclerView;
        private MainViewAdapter adapter;
        private ArrayList<StyleRecyclerItem> list = new ArrayList<>();

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_style, container, false);

            recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
            swipeToRefresh = rootView.findViewById(R.id.swipeToRefresh);

            ArrayList<StyleRecyclerItem> list = new ArrayList<StyleRecyclerItem>();
            list.add(new StyleRecyclerItem(R.drawable.style_image1, "승아네 seungahne","실패할 수 없는 색조합 코디꿀팁","연남동 나들이룩에 찰-떡"));
            list.add(new StyleRecyclerItem(R.drawable.style_image2, "혜성 MoonBrand","오늘 같은 날씨에 딱 어울리는 러블리","하이틴룩"));
            list.add(new StyleRecyclerItem(R.drawable.style_image3, "THIS IS MATE 디씨즈마테","마테에게 간택당한 옷들을 소개한다.","#당진시에게 #LA입는법"));
            list.add(new StyleRecyclerItem(R.drawable.style_image4, "[MD's PICK]다시 돌아왔따! 키큰녀는 클릭클릭! ","기장 걱정은 하덜 말아유! 키큰녀 하의","룩북"));
            list.add(new StyleRecyclerItem(R.drawable.style_image5, "우린","기획전 진행중 믿고보는 리뷰쿤의 베이지 갬성룩","베이지 갬성룩 (~56% 할인)"));
            list.add(new StyleRecyclerItem(R.drawable.style_image6, "한별 Hanbyul","패션유튜버 클라쓰 나만 알고 싶은","데님 코디법 대방출"));
            list.add(new StyleRecyclerItem(R.drawable.style_image7, "에바 EVA","72만 유튜버의 일주일 일상 속 찐","데일리룩"));
            list.add(new StyleRecyclerItem(R.drawable.style_image8, "[MD's PICK]귀염뽀짝 트윈룩 코디 추천!","너 혹시 이 옷 나랑 같이","입을래...?(feat.쌍둥이 김소녀)"));
            list.add(new StyleRecyclerItem(R.drawable.style_image9, "엘피디 윤정","뚱뚱하면 크롭 못입음? 통통족의","러블리 힙 감성 보여준다"));
            list.add(new StyleRecyclerItem(R.drawable.style_image10, "이주아jua","10대 요청대폭주 허벅지 영원히","롱다리로 보이는 9가지 코디"));


            recyclerView.setHasFixedSize(true);
            adapter = new MainViewAdapter(getActivity(), list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);


            swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // 새로고침 코드

                    // 새로고침 완료
                    swipeToRefresh.setRefreshing(false);
                }
            });


            Log.e("Frag", "MainFragment");
            return rootView;
        }
    }

