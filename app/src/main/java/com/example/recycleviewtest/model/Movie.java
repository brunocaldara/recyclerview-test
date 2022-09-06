package com.example.recycleviewtest.model;

public class Movie {
    private String title;
    private String gender;
    private Integer year;
    private Integer rate;

    public Movie(String title, String gender, Integer year, Integer rate) {
        this.title = title;
        this.gender = gender;
        this.year = year;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
