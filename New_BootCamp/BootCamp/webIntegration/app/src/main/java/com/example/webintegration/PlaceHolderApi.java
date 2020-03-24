package com.example.webintegration;

import retrofit2.Call;
import retrofit2.http.GET;

public  interface PlaceHolderApi {
    @GET("v2/posts.json")
    Call<model> getJsonObjectData();
}
