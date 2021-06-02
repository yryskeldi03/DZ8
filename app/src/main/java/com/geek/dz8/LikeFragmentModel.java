package com.geek.dz8;

public class LikeFragmentModel {
    private int avatar, likePhoto;
    private String description, time;

    public LikeFragmentModel(int avatar, int likePhoto, String description, String time) {
        this.avatar = avatar;
        this.likePhoto = likePhoto;
        this.description = description;
        this.time = time;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getLikePhoto() {
        return likePhoto;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }
}
