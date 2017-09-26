package com.example.kiran.fruitveg;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kiran on 9/21/2017.
 */
public class Calories implements Serializable{

    @SerializedName("name")
    private String Name;

    @SerializedName("image_path")
    private String Image_path;

    @SerializedName("calories")
    private int Calories;

    public String getName() {
        return Name;
    }

    public String getImage_path() {
        return Image_path;
    }

    public int getCalories() {
        return Calories;
    }
}

































































