package com.geektech.infinityapp.core;

import com.geektech.infinityapp.model.BoredAction;

public interface CoreCallback<T> {

    void getBoredAction(BoredActionCallBack callBack);

    interface BoredActionCallBack extends CoreCallback<BoredAction> {}
}
