package com.assignmet.network_utilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public static String BASE_URL="https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";
    private static Client client;
    private Retrofit retrofit;
    private Client(){
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized  Client getInstance(){
        if(client==null){
            client=new Client();
        }
        return client;
    }
    public ApiInterface getApi(){
       return retrofit.create(ApiInterface.class);
    }
}
