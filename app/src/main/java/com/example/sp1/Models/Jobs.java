package com.example.sp1.Models;

public class Jobs {
    private String client_id, county_image, county_name,  date_posted, end_date, general_area, job_description, job_price,
    sitter_id, specific_area, start_date, status, price;
    int imageName;

//    public Jobs(String client_id, String county_image, String county_name, String date_posted, String end_date, String general_area, String job_description, String job_price, String sitter_id, String specific_area, String start_date, String status, String postedBy, String county, String location, String price) {
//        this.client_id = client_id;
//        this.county_image = county_image;
//        this.county_name = county_name;
//        this.date_posted = date_posted;
//        this.end_date = end_date;
//        this.general_area = general_area;
//        this.job_description = job_description;
//        this.job_price = job_price;
//        this.sitter_id = sitter_id;
//        this.specific_area = specific_area;
//        this.start_date = start_date;
//        this.status = status;
//        this.postedBy = postedBy;
//        this.county = county;
//        this.location = location;
//        this.price = price;
//    }

    public Jobs(String county_name, String client_id, String general_area, String price, int imageName) {
        this.client_id = client_id;
        this.county_name = county_name;
        this.general_area = general_area;
        this.price = price;
        this.imageName = imageName;
    }

//    public Jobs(String county, String postedBy, String location, String price, int imageName) {
//        this.postedBy = postedBy;
//        this.county = county;
//        this.location = location;
//        this.price = price;
//        this.imageName = imageName;
//    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getCounty_image() {
        return county_image;
    }

    public void setCounty_image(String county_image) {
        this.county_image = county_image;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public String getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(String date_posted) {
        this.date_posted = date_posted;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getGeneral_area() {
        return general_area;
    }

    public void setGeneral_area(String general_area) {
        this.general_area = general_area;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getJob_price() {
        return job_price;
    }

    public void setJob_price(String job_price) {
        this.job_price = job_price;
    }

    public String getSitter_id() {
        return sitter_id;
    }

    public void setSitter_id(String sitter_id) {
        this.sitter_id = sitter_id;
    }

    public String getSpecific_area() {
        return specific_area;
    }

    public void setSpecific_area(String specific_area) {
        this.specific_area = specific_area;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
