package com.example.kiran.fruitveg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getFruit(View view) {
        Intent intent = new Intent(this,ListActivity.class);
        intent.putExtra("type","fruit");
        startActivity(intent);
    }

    public void getVegetable(View view) {
        Intent intent = new Intent(this,ListActivity.class);
        intent.putExtra("type","vegetable");
        startActivity(intent);
    }
}










































































