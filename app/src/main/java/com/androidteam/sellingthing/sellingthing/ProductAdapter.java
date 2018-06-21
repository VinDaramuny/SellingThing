package com.androidteam.sellingthing.sellingthing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.bumptech.glide.Glide;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    private ArrayList<String> imageUrl = new ArrayList<>();
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();
    private ArrayList<String> rate = new ArrayList<>();
    private ArrayList<String> price = new ArrayList<>();
    private Context mContext;

    public ProductAdapter(ArrayList<String> imageUrl, ArrayList<String> title, ArrayList<String> desc, ArrayList<String> rate, ArrayList<String> price, Context mContext) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.desc = desc;
        this.rate = rate;
        this.price = price;
        this.mContext = mContext;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView productTitle;
        TextView productDesc;
        TextView productRate;
        TextView productPrice;
        ImageView productImg;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.textViewTitle);
            productDesc = itemView.findViewById(R.id.textViewDes);
            productRate = itemView.findViewById(R.id.textViewRating);
            productPrice = itemView.findViewById(R.id.textViewPrice);
            productImg = itemView.findViewById(R.id.imageViewProductct);
            linearLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.productTitle.setText(title.get(position));
        holder.productDesc.setText(desc.get(position));
        holder.productRate.setText(rate.get(position));
        holder.productPrice.setText(price.get(position));
        //Glide.with(mContext).asBitmap().load(imageUrl.get(position)).into(holder.productImg);
        Glide.with(mContext).asBitmap().load(imageUrl.get(position)).into(holder.productImg);

    }

    @Override
    public int getItemCount() {
        return title.size();
    }
}
