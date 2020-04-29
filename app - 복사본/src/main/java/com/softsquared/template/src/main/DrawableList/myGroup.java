package com.softsquared.template.src.main.DrawableList;

import java.util.ArrayList;
public class myGroup {
    public ArrayList<String> child;
    public String groupName;
    public myGroup(String name){
        groupName = name;
        child = new ArrayList<String>();
    }
}

