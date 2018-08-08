package com.shilpa.ATGGalleryApp.home;


import android.util.Log;

import com.shilpa.ATGGalleryApp.api.ApiService;
import com.shilpa.ATGGalleryApp.api.ApiServiceBuilder;
import com.shilpa.ATGGalleryApp.api.ApiServiceImpl;
import com.shilpa.ATGGalleryApp.api.AppService;
import com.shilpa.ATGGalleryApp.api.InternetConnectionTestHelper;
import com.shilpa.ATGGalleryApp.api.NetworkTestHelper;
import com.shilpa.ATGGalleryApp.common.OperationHandler;
import com.shilpa.ATGGalleryApp.model.PhotoData;

public class HomePresenterImpl implements HomePresenter {
    public String combined;
    HomeView homeView;
    ApiService apiService;
    NetworkTestHelper networkTestHelper;
    InternetConnectionTestHelper internetConnectionTestHelper;
    OperationHandler appOperationHandler;
    AppService appService;
    String token;


    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        networkTestHelper = new NetworkTestHelper();
        internetConnectionTestHelper = new InternetConnectionTestHelper(networkTestHelper);
        apiService = new ApiServiceImpl(internetConnectionTestHelper);
        appService = ApiServiceBuilder.buildService(null, AppService.class);

        appOperationHandler = OperationHandler.getOperationHandler();
    }


    @Override
    public void loadImages() {
        if (networkTestHelper.isNetworkConnected()) {

            apiService.loadImages("", new ApiService.Callback<PhotoData>() {
                @Override
                public void onSuccess(PhotoData response) {
                    if (response.getStat().equalsIgnoreCase("ok")) {
                        homeView.onRequestSuccess(response.getPhotos().getPhotos());

                    } else {

                    }
                }

                @Override
                public void onError(Throwable error) {
                    Log.e("Failed", "failed on error");
                    Log.e("Failed", error.getMessage());
                    //homeView.clearDataField();
                    //homeView.onRequestFailure(error.getLocalizedMessage());
                }
            });


        } else {
            homeView.onRequestFailure(networkTestHelper.ERROR_INTERNET_NOT_CONNECTED);
        }
    }

    @Override
    public void searchImage(String text) {
        if (networkTestHelper.isNetworkConnected()) {

            apiService.searchImages(text, new ApiService.Callback<PhotoData>() {
                @Override
                public void onSuccess(PhotoData response) {
                    if (response.getStat().equalsIgnoreCase("ok")) {
                        homeView.onRequestSuccess(response.getPhotos().getPhotos());

                        //}Log.e("TOKENNN", token + "dd");
                    } else {
                        // Log.e("FailedauthenticateUser", response.getSearchResponseData().get(0).getStatus());
                        //homeView.onRequestFailure(response.getTweets().get(0).getText());
                    }
                }

                @Override
                public void onError(Throwable error) {
                    Log.e("Failed", "failed on error");
                    Log.e("Failed", error.getMessage());
                    //homeView.clearDataField();
                    //homeView.onRequestFailure(error.getLocalizedMessage());
                }
            });


        } else {
            homeView.onRequestFailure(networkTestHelper.ERROR_INTERNET_NOT_CONNECTED);
        }

    }


}

