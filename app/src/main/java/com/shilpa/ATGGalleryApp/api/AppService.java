package com.shilpa.ATGGalleryApp.api;


import com.shilpa.ATGGalleryApp.model.PhotoData;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AppService {


    @GET("rest/?method=flickr.photos.getRecent&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")

    Call<PhotoData> getImages();

    @GET("rest/?method=flickr.photos.search&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s&")

    Call<PhotoData> getSearchImages(@Query("text") String text);

}
