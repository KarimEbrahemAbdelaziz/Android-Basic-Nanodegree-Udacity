package com.example.pc.newsapp;

/**
 * Created by akueisara on 10/9/2016.
 */

public class News {
    private String mDate;
    private String mUrl;
    private String mSection;
    private String mTitle;
    private String mType;

    public News(String title, String type, String date, String section, String url) {
        this.mTitle = title;
        this.mType = type;
        this.mDate = date;
        this.mSection = section;
        this.mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getType() {
        return mType;
    }

    public String getDate() {
        return mDate;
    }

    public String getSection() {
        return mSection;
    }

    public String getUrl() {
        return mUrl;
    }
}
