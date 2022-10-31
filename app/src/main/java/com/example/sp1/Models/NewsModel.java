package com.example.sp1.Models;

public class NewsModel {
    private String title, location;
    private int imageUrl;
    private float starRating;

    public NewsModel(String title, String location, int imageUrl, float starRating) {
        this.title = title;
        this.location = location;
        this.imageUrl = imageUrl;
        this.starRating = starRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }
}
