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

import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.style.fragment.MainViewAdapter;

import com.softsquared.template.src.main.bottomnavigation.style.fragment.StyleRecyclerItem;

import java.util.ArrayList;

public class StyleFragment extends Fragment {

        private RecyclerView recyclerView;
        private MainViewAdapter adapter;
        private ArrayList<StyleRecyclerItem> list = new ArrayList<>();

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_style, container, false);

            recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

            ArrayList<StyleRecyclerItem> list = new ArrayList<StyleRecyclerItem>();

            list.add(new StyleRecyclerItem(R.drawable.style_image1, "THIS IS MATE 디씨즈 마테","마테에게 간택당한 옷들을 소개한다.","#당진시에서 #LA입는법"));
            list.add(new StyleRecyclerItem(R.drawable.style_image2, "[MD's PICK] 다시 돌아왔따! 키큰녀는 클릭클릭!","기장 걱정은 하덜 말아유! 키큰녀 하의","룩북"));
            list.add(new StyleRecyclerItem(R.drawable.style_image3, "우린","기획전 진행중 믿고보는 리뷰퀸의","베이지 갬성룩 (~56%할인"));
            list.add(new StyleRecyclerItem(R.drawable.style_image4, "wohahahaha","2222","333"));
            list.add(new StyleRecyclerItem(R.drawable.style_image5, "wohahahaha","2222","333"));
            list.add(new StyleRecyclerItem(R.drawable.style_image6, "wohahahaha","2222","333"));
            list.add(new StyleRecyclerItem(R.drawable.style_image7, "wohahahaha","2222","333"));
            list.add(new StyleRecyclerItem(R.drawable.style_image8, "wohahahaha","2222","333"));
            list.add(new StyleRecyclerItem(R.drawable.style_image9, "wohahahaha","2222","333"));
            list.add(new StyleRecyclerItem(R.drawable.style_image10, "wohahahaha","2222","333"));


            recyclerView.setHasFixedSize(true);
            adapter = new MainViewAdapter(getActivity(), list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);

            Log.e("Frag", "MainFragment");
            return rootView;
        }
    }

