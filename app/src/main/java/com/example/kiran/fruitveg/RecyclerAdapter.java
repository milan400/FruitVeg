package com.example.kiran.fruitveg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;

/**
 * Created by kiran on 9/21/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Calories> calories;
    private Context context;
    OnCardClickListener onCardClickListener;
    private RecyclerView mRecyclerView;

    public RecyclerAdapter(List<Calories> calories,Context context,OnCardClickListener monCardClickListener)
    {
        this.calories = calories;
        this.context = context;
        this.onCardClickListener = monCardClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout,parent,false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Calories calorie = calories.get(position);

        holder.Name.setText(calories.get(position).getName());
        holder.Calories.setText("Calories:"+ Integer.toString(calories.get(position).getCalories()));
        Glide.with(context).load(calories.get(position).getImage_path()).into(holder.img);
        
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardClickListener.OnCardClicked(view,position);
                Intent in = new Intent(context,Detail.class);
                in.putExtra("calorie",calorie);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);

            }
        });
        
        
    }

    @Override
    public int getItemCount() {
        return calories.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView img;
        TextView Name,Calories;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.img);
            Name = (TextView)itemView.findViewById(R.id.name);
            Calories = (TextView)itemView.findViewById(R.id.calories);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }

        @Override
        public void onClick(View view) {

        }
    }
    public interface OnCardClickListener
    {
        void OnCardClicked(View view,int position);
    }
    public void setOnCardClickListener(OnCardClickListener onCardClickListener)
    {
        this.onCardClickListener = onCardClickListener;
    }

}







































































