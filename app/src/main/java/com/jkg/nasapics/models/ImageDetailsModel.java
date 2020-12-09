package com.jkg.nasapics.models;

import java.io.Serializable;

public class ImageDetailsModel implements Serializable {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String title;
    private String url;

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
