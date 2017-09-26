package com.example.kiran.fruitveg;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    private ImageView detailimg;
    Calories i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toast.makeText(Detail.this, "detail", Toast.LENGTH_SHORT).show();

        detailimg = (ImageView) findViewById(R.id.detailimg);
        if(getIntent().getSerializableExtra("calorie") != null){
            i = (Calories) getIntent().getSerializableExtra("calorie");
            Glide.with(getApplicationContext()).load(i.getImage_path()).into(detailimg);


        }

    }
}









































































