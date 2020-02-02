package com.assignmet.network_utilities;

import com.assignmet.model.ListQueryResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("facts.json")
    Call<ListQueryResult> getData();
}
