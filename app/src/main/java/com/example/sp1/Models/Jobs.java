package com.example.sp1.Models;

public class Jobs {
//    private String jobuid, status, description, county, location, name, price, postedBy, acceptedBy;
private String postedBy, county, location, price;
int imageName;

    public Jobs( String county, String postedBy, String location, String price, int imageName) {
        this.postedBy = postedBy;
        this.county = county;
        this.location = location;
        this.price = price;
        this.imageName = imageName;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }
}
