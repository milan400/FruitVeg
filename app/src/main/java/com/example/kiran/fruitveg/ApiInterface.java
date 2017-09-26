package com.example.kiran.fruitveg;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by kiran on 9/20/2017.
 */
public interface ApiInterface {


    @GET("getcalories.php")
    Call<List<Calories>> getCaloriesInfo(@Query("item_type") String item_type);
}














































































