package com.androidteam.sellingthing.sellingthing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    Product product;
    TextView productTitle;
    TextView productDesc;
    TextView productRate;
    TextView productPrice;
    ImageView productImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView buttonBack = findViewById(R.id.btnBack);
        Intent getProductDetail = getIntent();
        product = (Product)getProductDetail.getSerializableExtra("product_detail");

        productTitle = findViewById(R.id.textViewProductTitle);
        productImg = findViewById(R.id.imageViewProduct);
        productPrice = findViewById(R.id.textViewProductPrice);
        productDesc = findViewById(R.id.textViewProductDesc);

        productTitle.setText(product.getTitle());
        productPrice.setText(product.getPrice());
        productDesc.setText(product.getDesc());
        Glide.with(this).asBitmap().load(product.getImgUrl()).into(productImg);


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
