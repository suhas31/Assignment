package com.assignmet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListQueryResult {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private ArrayList<ListRows> rowsArrayList = null;

    public ListQueryResult() {

    }

    public ListQueryResult(String title, ArrayList<ListRows> rowsArrayList) {
        this.title = title;
        this.rowsArrayList = rowsArrayList;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ListRows> getRes() {
        return rowsArrayList;
    }

    public void setRes(ArrayList<ListRows> rowsArrayList) {
        this.rowsArrayList = rowsArrayList;
    }
}
