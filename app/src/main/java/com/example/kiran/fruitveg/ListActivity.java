package com.example.kiran.fruitveg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity implements RecyclerAdapter.OnCardClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Calories> calories;
    private RecyclerAdapter adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        calories = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerAdapter(calories,ListActivity.this,ListActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.setOnCardClickListener(this);
        if(getIntent().getExtras()!=null)
        {
            String type = getIntent().getExtras().getString("type");
            fetchInformation(type);
        }

    }
    public void fetchInformation(String type)
    {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Calories>> call = apiInterface.getCaloriesInfo(type);
        call.enqueue(new Callback<List<Calories>>() {
            @Override
            public void onResponse(Call<List<Calories>> call, Response<List<Calories>> response) {
                calories = response.body();
                adapter = new RecyclerAdapter(calories,ListActivity.this,ListActivity.this);
                recyclerView.setAdapter(adapter);
                Toast.makeText(ListActivity.this, "Network", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Calories>> call, Throwable t) {
                Toast.makeText(ListActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void OnCardClicked(View view, int position) {

    }
}













































































