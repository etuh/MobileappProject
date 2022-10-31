package com.example.sp1.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sp1.Models.NewsModel;
import com.example.sp1.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>{
    private List<NewsModel> newsModelList;

    public NewsAdapter(List<NewsModel> newsModelList) {
        this.newsModelList = newsModelList;
    }

    @NonNull
    @Override
    public NewsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsAdapterViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_layout,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapterViewHolder holder, int position) {
        holder.setLocation(newsModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }

    static class NewsAdapterViewHolder extends RecyclerView.ViewHolder{
        private KenBurnsView kenBurnsView;
        private int [] images={R.mipmap.dog1, R.drawable.dog2, R.drawable.dog3};
        private TextView textTitle, textLocation, textRating;
        public NewsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            kenBurnsView = itemView.findViewById(R.id.kbLocation);
        }
        void setLocation(NewsModel newsModel){
            Picasso.get().load(newsModel.getImageUrl()).into(kenBurnsView);
        }
    }


}
