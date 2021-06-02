package com.geek.dz8;

public class HomeFragmentModel {
    private String description,date;
    private int image;

    public HomeFragmentModel(String description, String date, int image) {
        this.description = description;
        this.date = date;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public int getImage() {
        return image;
    }
}
