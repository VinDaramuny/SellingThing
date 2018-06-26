package com.androidteam.sellingthing.sellingthing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.bumptech.glide.Glide;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    private List<Product> productList;

//    private ArrayList<String> desc = new ArrayList<>();
//    private ArrayList<String> rate = new ArrayList<>();
//    private ArrayList<String> price = new ArrayList<>();
    private Context mContext;

//    public ProductAdapter(ArrayList<String> imageUrl, ArrayList<String> title, ArrayList<String> desc, ArrayList<String> rate, ArrayList<String> price, Context mContext) {
//        this.imageUrl = imageUrl;
//        this.title = title;
//        this.desc = desc;
//        this.rate = rate;
//        this.price = price;
//        this.mContext = mContext;
//    }


    public ProductAdapter(List<Product> productList, Context mContext) {
        this.productList = productList;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView productTitle;
//        TextView productDesc;
//        TextView productRate;
//        TextView productPrice;
        ImageView productImg;
        LinearLayout parentLayout;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.textViewTitle);
//            productDesc = itemView.findViewById(R.id.textViewDes);
//            productRate = itemView.findViewById(R.id.textViewRating);
//            productPrice = itemView.findViewById(R.id.textViewPrice);
            productImg = itemView.findViewById(R.id.imageviewproduct);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            cardView = itemView.findViewById(R.id.card_view);
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

    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.productTitle.setText(title.get(position));
//        Glide.with(mContext).asBitmap().load(imageUrl.get(position)).into(holder.productImg);
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, title.get(position), Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(mContext, DetailActivity.class);
////                intent.putExtra("image_url", mImages.get(position));
////                intent.putExtra("image_name", mImageNames.get(position));
//                mContext.startActivity(intent);
//            }
//        }
        final Product product = productList.get(position);
        holder.productTitle.setText(product.getTitle());
        Glide.with(mContext).asBitmap().load(product.getImgUrl()).into(holder.productImg);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,product.getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailActivity.class);
//                intent.putExtra("image_url", mImages.get(position));
//                intent.putExtra("image_name", mImageNames.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
