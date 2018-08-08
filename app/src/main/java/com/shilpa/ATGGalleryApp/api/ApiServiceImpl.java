package com.shilpa.ATGGalleryApp.api;

import android.util.Base64;
import android.util.Log;

import com.shilpa.ATGGalleryApp.common.Constants;
import com.shilpa.ATGGalleryApp.model.PhotoData;

import retrofit2.Response;


public class ApiServiceImpl implements ApiService {
    private AppService appService;
    private InternetConnectionTestHelper internetConnectionTestHelper;

    public ApiServiceImpl(InternetConnectionTestHelper internetConnectionTestHelper){
        appService = ApiServiceBuilder.buildService(null, AppService.class);
        this.internetConnectionTestHelper = internetConnectionTestHelper;
    }








    @Override
    public void loadImages(String s,final Callback<PhotoData> callback) {
        appService.getImages().enqueue(new ErrorTransformingCallback<PhotoData>(internetConnectionTestHelper) {
            @Override
            public void onSuccessResponse(Response<PhotoData> response) {
                if(response.body() != null) {
                    Log.e("TokenResponseData", "ss"+response.body().getStat());
                    callback.onSuccess(response.body());
                } else{
                    callback.onError(new Throwable(response.message()));
                }
//                Log.e("SearchResponseData", "ss"+response.body().getTweets().size());
            }

            @Override
            public void onErrorOccurred(Throwable throwable, Response<PhotoData> response) {
                callback.onError(throwable);
            }

        });
    }

    @Override
    public void searchImages(String text,final Callback<PhotoData> callback) {
        appService.getSearchImages(text).enqueue(new ErrorTransformingCallback<PhotoData>(internetConnectionTestHelper) {
            @Override
            public void onSuccessResponse(Response<PhotoData> response) {
                if(response.body() != null) {
                    Log.e("TokenResponseData", "ss"+response.body().getStat());
                    callback.onSuccess(response.body());
                } else{
                    callback.onError(new Throwable(response.message()));
                }
//                Log.e("SearchResponseData", "ss"+response.body().getTweets().size());
            }

            @Override
            public void onErrorOccurred(Throwable throwable, Response<PhotoData> response) {
                callback.onError(throwable);
            }

        });
    }
}
