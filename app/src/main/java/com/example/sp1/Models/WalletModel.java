package com.example.sp1.Models;

public class WalletModel {
    private String employer_name, status, start_date, timeframe, wallet_price;
    int profileImage;

    public WalletModel(String employer_name, String status, String start_date, String timeframe, String wallet_price, int profileImage) {
        this.employer_name = employer_name;
        this.status = status;
        this.start_date = start_date;
        this.timeframe = timeframe;
        this.wallet_price = wallet_price;
        this.profileImage = profileImage;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public String getStatus() {
        return status;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public String getWallet_price() {
        return wallet_price;
    }

    public int getProfileImage() {
        return profileImage;
    }
}
