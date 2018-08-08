package com.shilpa.ATGGalleryApp.api;


import com.shilpa.ATGGalleryApp.model.PhotoData;

public interface ApiService {

    void loadImages(String s, Callback<PhotoData> callback);

    void searchImages(String text, Callback<PhotoData> callback);


    interface Callback<T>{
        void onSuccess(T response);
        void onError(Throwable error);
    }
}
