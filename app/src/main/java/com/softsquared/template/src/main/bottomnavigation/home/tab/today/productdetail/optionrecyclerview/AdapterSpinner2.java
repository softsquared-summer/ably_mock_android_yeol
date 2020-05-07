package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.datapojo.OptionResult;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.option.SecondOptionItem;

import java.util.List;

/**
 * Created by gwon on 2016-12-03.
 */

public class AdapterSpinner2 extends BaseAdapter {


    Context context;
    List<SecondOptionItem> data;
    LayoutInflater inflater;


    public AdapterSpinner2(Context context, List<SecondOptionItem> data){
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        if(data!=null) return data.size();
        else return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.buydialog_spiner, parent, false);
        }

        TextView tv = convertView.findViewById(R.id.spinnerText);
        tv.setTextSize(12);
        tv.setTextColor(Color.GRAY);

        if(data!=null){
            //데이터세팅
            String text = data.get(position).getSecondOption();
            tv.setText(text);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.buydialog_spiner_dropdown, parent, false);
        }

        //데이터세팅
        String text = data.get(position).getSecondOption();
        String text2 = data.get(position).getPrice();
        ((TextView)convertView.findViewById(R.id.spinnerText)).setText(text);
        ((TextView)convertView.findViewById(R.id.spinnerText2)).setText(text2);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
