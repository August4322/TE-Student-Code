package com.techelevator.hotels.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PictureOfTheDay {

    @JsonProperty("copyright")
    String photographer;
    String title;
    String explanation;
    String url;

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
