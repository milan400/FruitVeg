package com.example.kiran.fruitveg;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kiran on 9/20/2017.
 */
public class ApiClient {

    public static final String BASE_URL = "https://caloriedb.000webhostapp.com/";

    public static Retrofit retrofit = null;

    public static Retrofit getApiClient()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}































































