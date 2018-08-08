package com.shilpa.ATGGalleryApp.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class photos
    {

        @SerializedName("photo")
        public ArrayList<Photo> photos;

        private String total;

        private String page;

        private String pages;



        private String perpage;

        public ArrayList<Photo> getPhotos() {
            return photos;
        }

        public void setPhotos(ArrayList<Photo> photos) {
            this.photos = photos;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public String getPerpage() {
            return perpage;
        }

        public void setPerpage(String perpage) {
            this.perpage = perpage;
        }
    }
