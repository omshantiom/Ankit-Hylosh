package com.example.hp.aha.activity.adapter;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.hp.aha.R;
import com.example.hp.aha.activity.model.SearchData;

import java.util.ArrayList;
import java.util.List;

public class SearchDataAdapter extends RecyclerView.Adapter<SearchDataAdapter.MyViewHolder> {
    private ArrayList<SearchData> data = null;
    private int minteger = 0;
    private Context mcontext;
    private static int counter;
    private String stringVal;
    private int myCount=0;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView header,weight;
        public ImageView product_img;
        public RadioButton product_price_delivery;
        public RadioButton product_price_pickup;

        public TextView displayInteger;
        public Button increase,decrease;

        public MyViewHolder(View view) {
            super(view);
            header = (TextView) view.findViewById(R.id.header);
            weight = (TextView) view.findViewById(R.id.weight);
            product_img = (ImageView) view.findViewById(R.id.product_img);
            product_price_delivery = (RadioButton) view.findViewById(R.id.product_price_delivery);
            product_price_pickup= (RadioButton) view.findViewById(R.id.product_price_pickup);
            displayInteger = (TextView) view.findViewById(R.id.integer_number);
            increase = (Button) view.findViewById(R.id.increase);
            decrease = (Button) view.findViewById(R.id.decrease);
        }
    }


    public SearchDataAdapter(Context mcontext,ArrayList<SearchData> data) {
        this.mcontext=mcontext;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_data_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        SearchData searchData = data.get(position);
        holder.header.setText(searchData.getMeta_title());

        double d1 = Double.parseDouble(searchData.getWeight());
        holder.weight.setText(String.format("%.0f",d1 )+" kg");

        double d = Double.parseDouble(searchData.getPrice());
        holder.product_price_delivery.setText("Rs. "+String.format("%.0f",d )+" Doorstep deliver by kirana");
        holder.product_price_pickup.setText("Rs. "+String.format("%.0f",d )+" Pickup by nearby store");

        holder.displayInteger.setText("0");

        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minteger < 11) {
                    minteger = minteger + 1;
                    holder.displayInteger.setText("" + minteger);
                }
            }
        });
        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (minteger > 0) {
                    minteger = minteger - 1;
                    holder.displayInteger.setText("" + minteger);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}