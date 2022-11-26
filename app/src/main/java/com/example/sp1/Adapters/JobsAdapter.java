package com.example.sp1.Adapters;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sp1.Activities.ViewJob;
import com.example.sp1.Models.Jobs;
import com.example.sp1.R;

import java.util.ArrayList;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {
    Context context;
    ArrayList<Jobs>jobsModel;
    public JobsAdapter(Context context, ArrayList<Jobs>jobsModel) {
        this.context=context;
        this.jobsModel=jobsModel;
    }

    @NonNull
    @Override
    public JobsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.jobs_row, parent, false);
        return new JobsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsAdapter.MyViewHolder holder, int position) {
    holder.countyName.setText(jobsModel.get(position).getCounty_name());
    holder.personName.setText(jobsModel.get(position).getClient_id());
    holder.locationName.setText(jobsModel.get(position).getGeneral_area());
    holder.priceTag.setText(jobsModel.get(position).getPrice());
//    holder.imageView.setImageResource(jobsModel.get(position).getImageName());
        holder.viewJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ViewJob.class);
                context.startActivity(i);

                    //Toast.makeText(context, "Hello",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobsModel.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        Button viewJob;
        TextView countyName, personName, locationName, priceTag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            viewJob = itemView.findViewById(R.id.view_job);
            imageView = itemView.findViewById(R.id.image_location);
            countyName = itemView.findViewById(R.id.county_title);
            personName = itemView.findViewById(R.id.person_name);
            locationName = itemView.findViewById(R.id.location_name);
            priceTag = itemView.findViewById(R.id.job_price);


        }
    }
}
