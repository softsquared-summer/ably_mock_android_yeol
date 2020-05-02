package com.softsquared.template.src.main.bottomnavigation.market.fragment;

public class MarketRecycleItem {

    private int iconDrawable ;
    private int iconDrawable2 ;
    private int iconDrawable3 ;
    private String titleStr ;
    private String descStr ;
    private String descStr2 ;
    private String descStr3 ;
    private String descStr4 ;

    public MarketRecycleItem(int iconDrawable, int iconDrawable2, int iconDrawable3, String titleStr, String descStr, String descStr2, String descStr3, String descStr4) {
        this.iconDrawable = iconDrawable;
        this.iconDrawable2 = iconDrawable2;
        this.iconDrawable3 = iconDrawable3;
        this.titleStr = titleStr;
        this.descStr = descStr;
        this.descStr2 = descStr2;
        this.descStr3 = descStr3;
        this.descStr4 = descStr4;
    }

    public int getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public int getIconDrawable2() {
        return iconDrawable2;
    }

    public void setIconDrawable2(int iconDrawable2) {
        this.iconDrawable2 = iconDrawable2;
    }

    public int getIconDrawable3() {
        return iconDrawable3;
    }

    public void setIconDrawable3(int iconDrawable3) {
        this.iconDrawable3 = iconDrawable3;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getDescStr() {
        return descStr;
    }

    public void setDescStr(String descStr) {
        this.descStr = descStr;
    }

    public String getDescStr2() {
        return descStr2;
    }

    public void setDescStr2(String descStr2) {
        this.descStr2 = descStr2;
    }

    public String getDescStr3() {
        return descStr3;
    }

    public void setDescStr3(String descStr3) {
        this.descStr3 = descStr3;
    }

    public String getDescStr4() {
        return descStr4;
    }

    public void setDescStr4(String descStr4) {
        this.descStr4 = descStr4;
    }
}
