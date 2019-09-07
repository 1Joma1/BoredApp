package com.geektech.infinityapp.data;

import com.geektech.infinityapp.model.BoredAction;

public interface IBoredApiClient {

    void getBoredAction(BoredActionCallBack callBack);

    interface BoredActionCallBack {
        void onSuccess(BoredAction action);

        void onFailure(Exception e);
    }
}
