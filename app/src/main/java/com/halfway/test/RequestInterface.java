package com.halfway.test;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("/stocks.json")
    Call<Card> getCard();
}
