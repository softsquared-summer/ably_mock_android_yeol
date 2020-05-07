package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionrecyclerview;



import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.softsquared.template.R;


import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.Cart.CartItem;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.datapojo.OptionResult;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends BaseAdapter {

    private ArrayList<CartItem> productlist;
    private LayoutInflater inflater;
    private ViewHolder Holder;
    private Context mContext;
    private ArrayList listitem;


    public CartAdapter(ArrayList<CartItem> productlist, Context context) {
        this.mContext = context;
        this.productlist = productlist;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayList listitem = new ArrayList();
    }

    @Override
    public int getCount() {
        return productlist.size();
    }

    @Override
    public Object getItem(int position) {
        return productlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴.
    @SuppressLint("ResourceType")
    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        final int checkBoxposition = position;
        // 한번도 화면이 생성된적이 없을 경우
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_itemdetail_buydialog, viewGroup, false);
            Holder = new ViewHolder(convertView); // 화면에서 사라진 view를 담아두기 위한 용도.

            convertView.setTag(Holder);

        }
        // 한번이라도 화면이 생성된적이 있을 경우
        else {
            Holder = (ViewHolder) convertView.getTag();
        }
/*
        Holder.product_explain.setText(productlist.get(position).getProduct_explain());
        Holder.product_name.setText(productlist.get(position).getProduct_name());
        Holder.product_explain.setText(productlist.get(position).getProduct_explain());
        Holder.product_price.setText(productlist.get(position).getProduct_price());
        Holder.product_Quantity.setText("" + productlist.get(position).getProduct_Quantity());
        Holder.product_swtich.setChecked(productlist.get(position).getProduct_swtich());

        // 고정
        //      Holder.product_Image.setImageResource(R.drawable.product1);
        Holder.product_gaguk.setText("가격");
        Holder.product_minus.setImageResource(R.drawable.plus);
        Holder.product_plus.setImageResource(R.drawable.minus);
*/


/*
        final int Quantity = productlist.get(position).getProduct_Quantity();

        // +버튼
        ImageButton plus_button = (ImageButton) convertView.findViewById(R.id.product_plus);
        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Quantity<100) {
                    productlist.get(position).setProduct_Quantity(Quantity + 1);
                    Holder.product_Quantity.setText("" + productlist.get(position).getProduct_Quantity());
                    notifyDataSetChanged();
                }
                else{
                    Toast.makeText(mContext,"상품은 100개 이상 주문할 수 없어요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // -버튼튼
        ImageButton minus_button = (ImageButton) convertView.findViewById(R.id.product_minus);
        minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Quantity > 1) {
                    productlist.get(position).setProduct_Quantity(Quantity - 1);
                    Holder.product_Quantity.setText("" + productlist.get(position).getProduct_Quantity());
                    notifyDataSetChanged();
                }
                else{
                    Toast.makeText(mContext,"상품은 1개 이상 주문할 수 있습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //  final CheckBox Swtich_button = (CheckBox)convertView.findViewById(R.id.product_switch);
        Holder.product_swtich.setOnClickListener(new View.OnClickListener(){

            product checkViewitem = (product)getItem(checkBoxposition);

            @Override
            public void onClick(View v) {

                if(checkViewitem.getProduct_swtich()){
                    productlist.get(position).setProduct_swtich(false);

                }
                else{
                    productlist.get(position).setProduct_swtich(true);

                }
                notifyDataSetChanged();
            }
        });

        Holder.product_swtich.setChecked( productlist.get(position).getProduct_swtich());


        Button deletebutton = convertView.findViewById(R.id.product_delete);

        // loginActivty -> createmember 액티비티 이동 버튼 이벤트
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productlist.remove(position);
                notifyDataSetChanged();
            }
        };
        deletebutton.setOnClickListener(listener);



*/

        return convertView;
    }



    public class ViewHolder {
        private ImageView product_Image;
        private TextView product_name;
        private TextView product_explain;
        private TextView product_price;
        private TextView product_gaguk;
        private TextView product_Quantity;

        private ImageButton product_minus;
        private ImageButton product_plus;

        private CheckBox product_swtich;

        public ViewHolder(View view) {

            /*
            this.product_Image = view.findViewById(R.id.order_pic);
            this.product_name = view.findViewById(R.id.order_name);
            this.product_explain = view.findViewById(R.id.order_explain);
            this.product_price = view.findViewById(R.id.order_price);
            this.product_gaguk = view.findViewById(R.id.order_gaguk);
            this.product_Quantity = view.findViewById(R.id.order_quality);

            this.product_minus = view.findViewById(R.id.product_minus);
            this.product_plus = view.findViewById(R.id.product_plus);

            this.product_swtich = view.findViewById(R.id.product_switch);
*/
        }


    }
}
