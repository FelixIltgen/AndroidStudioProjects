package com.example.mystore;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList book_id, book_titel, book_author, book_ispn, book_rating;

    CustomAdapter(Activity activity,Context context, ArrayList book_id,
                  ArrayList book_titel,
                  ArrayList book_author,
                  ArrayList book_ispn,
                  ArrayList book_rating){
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_titel = book_titel;
        this.book_author = book_author;
        this.book_ispn = book_ispn;
        this.book_rating = book_rating;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder,int position) {

        holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
        holder.book_titel_txt.setText(String.valueOf(book_titel.get(position)));
        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        holder.book_ispn_txt.setText(String.valueOf(book_ispn.get(position)));
        holder.book_rating_txt.setText(String.valueOf(book_rating.get(position)));

        holder.mainLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context,UpdateActivity.class);
            intent.putExtra("id",String.valueOf(book_id.get(position)));
            intent.putExtra("titel",String.valueOf(book_titel.get(position)));
            intent.putExtra("author",String.valueOf(book_author.get(position)));
            intent.putExtra("ispn",String.valueOf(book_ispn.get(position)));
            intent.putExtra("rating",String.valueOf(book_rating.get(position)));
            activity.startActivityForResult(intent,1);
        });
    }
    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView book_id_txt, book_titel_txt, book_author_txt, book_ispn_txt, book_rating_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_titel_txt = itemView.findViewById(R.id.book_titel_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            book_ispn_txt = itemView.findViewById(R.id.book_ispn_txt);
            book_rating_txt = itemView.findViewById(R.id.book_rating_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
