package com.softsquared.template.src.main.bottomnavigation.style.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.softsquared.template.R;
import java.util.ArrayList;

public class StyleRecyclerItem {
    private int iconDrawable ;
    private String titleStr ;
    private String descStr ;
    private String descStr2 ;

    public StyleRecyclerItem(int iconDrawable, String titleStr, String descStr, String descStr2) {
        this.iconDrawable = iconDrawable;
        this.titleStr = titleStr;
        this.descStr = descStr;
        this.descStr2 = descStr2;
    }


    public void setIcon(int icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) { titleStr = title ; }
    public void setDesc(String desc) {
        descStr = desc ;
    }
    public void setDesc2(String desc) {
        descStr2 = desc ;
    }

    public int getIcon() { return this.iconDrawable ; }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
    public String getDesc2() {
        return this.descStr2 ;
    }




}