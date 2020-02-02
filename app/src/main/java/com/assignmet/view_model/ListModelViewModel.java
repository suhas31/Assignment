package com.assignmet.view_model;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import com.assignmet.model.ListQueryResult;
import com.assignmet.model.ListRows;
import com.assignmet.network_utilities.ApiInterface;
import com.assignmet.network_utilities.Client;
import com.assignmet.network_utilities.EspressoIdlingResouce;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListModelViewModel extends ViewModel {
    public String title;
    public ArrayList<ListRows> rowsArrayList;
    public MutableLiveData<ListModelViewModel> mutableLiveData=new MutableLiveData<>();
    ListModelViewModel listViewModels;

    public ListModelViewModel(){

    }
    public ListModelViewModel(ListQueryResult listQueryResult){
        title=listQueryResult.getTitle();
        rowsArrayList=listQueryResult.getRes();
    }

    public MutableLiveData<ListModelViewModel> getMutableLiveData(){
        ApiInterface apiInterface= Client.getInstance().getApi();
        // increment idling resource for telling Espresso wait for the RetroFit network's call
        EspressoIdlingResouce.increment();

        Call<ListQueryResult> call=apiInterface.getData();
        call.enqueue(new Callback<ListQueryResult>() {
            @Override
            public void onResponse(Call<ListQueryResult> call, Response<ListQueryResult> response) {
                // decrement idling resource to tell Espresso that the Retrofit Network call has been completed

                EspressoIdlingResouce.decrement();

                ListQueryResult listQueryResult=response.body();
                ListModelViewModel listModelViewModel=new ListModelViewModel(listQueryResult);
                mutableLiveData.setValue(listModelViewModel);
            }

            @Override
            public void onFailure(Call<ListQueryResult> call, Throwable t) {
                EspressoIdlingResouce.decrement();

            }
        });
        return mutableLiveData;
    }
}
