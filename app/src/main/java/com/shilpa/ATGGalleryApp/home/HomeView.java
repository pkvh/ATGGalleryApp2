package com.shilpa.ATGGalleryApp.home;


import com.shilpa.ATGGalleryApp.model.Photo;

import java.util.ArrayList;

public interface HomeView {

    void onRequestSuccess(ArrayList<Photo> photos);

    void onRequestFailure(String message);
}
