package com.shilpa.ATGGalleryApp.model;


import com.google.gson.annotations.SerializedName;

public class PhotoData {

    @SerializedName("photos")
    public photos photos;

    public photos getPhotos() {
        return photos;
    }

    public void setPhotos(photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    private String stat;
}
