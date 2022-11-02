package com.example.sp1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sp1.Models.Jobs;
import com.example.sp1.Models.WalletModel;
import com.example.sp1.R;

import java.util.ArrayList;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.MyViewHolder> {
    Context context;
    ArrayList<WalletModel> walletModel;

    public WalletAdapter(Context context, ArrayList<WalletModel> walletModel) {
        this.context = context;
        this.walletModel = walletModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.completed_row, parent, false);
        return new WalletAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(walletModel.get(position).getProfileImage());
        holder.employerName.setText(walletModel.get(position).getEmployer_name());
        holder.status.setText(walletModel.get(position).getStatus());
        holder.startDate.setText(walletModel.get(position).getStart_date());
        holder.timeFrame.setText(walletModel.get(position).getTimeframe());
        holder.priceRange.setText(walletModel.get(position).getWallet_price());


    }

    @Override
    public int getItemCount() {
        return walletModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView employerName, status, startDate, timeFrame, priceRange;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_job);
            employerName = itemView.findViewById(R.id.employer_name);
            status = itemView.findViewById(R.id.job_status);
            startDate = itemView.findViewById(R.id.job_start_date);
            timeFrame = itemView.findViewById(R.id.job_timeframe);
            priceRange = itemView.findViewById(R.id.job_price_range);


        }
    }
}
