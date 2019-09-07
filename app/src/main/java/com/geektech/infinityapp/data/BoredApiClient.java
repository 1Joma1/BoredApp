package com.geektech.infinityapp.data;

import com.geektech.infinityapp.core.CoreApiClient;
import com.geektech.infinityapp.core.ResponseHandler;
import com.geektech.infinityapp.model.BoredAction;

import retrofit2.Call;
import retrofit2.http.GET;

public class BoredApiClient extends CoreApiClient implements IBoredApiClient{
    //TODO: Create getRetrofitClient(baseUrl, class) method in CoreApiClient
    BoredNetworkClient client = getRetrofit("http://www.boredapi.com/").create(BoredNetworkClient.class);

    @Override
    public void getBoredAction(final BoredActionCallBack callBack) {
        Call<BoredAction> call = client.getBoredAction();

        call.enqueue(new ResponseHandler<BoredAction>() {

            @Override
            public void onSuccess(BoredAction result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onFailure(Exception e) {
                callBack.onFailure(e);
            }
        });
    }

    public interface BoredNetworkClient {
        @GET("api/activity/")
        Call<BoredAction> getBoredAction();
    }
}
