package com.shilpa.ATGGalleryApp.common;


import com.shilpa.ATGGalleryApp.utils.SharedPreferencesManager;

public class OperationHandler {

    private static OperationHandler operationHandler;

    private SharedPreferencesManager sharedPreferencesManager;

    private OperationHandler() {
        sharedPreferencesManager = SharedPreferencesManager.getInstance();
    }

    public static OperationHandler getOperationHandler() {
        return getInstance();
    }

    public static OperationHandler getInstance() {
        if (operationHandler == null) {
            operationHandler = new OperationHandler();
        }
        return operationHandler;
    }




   /* public void logout(){
        sharedPreferencesManager.clearLoginData();
        sharedPreferencesManager.setIsLoggedIn(false);
        this.searchResponseData = null;
    }*/


}
