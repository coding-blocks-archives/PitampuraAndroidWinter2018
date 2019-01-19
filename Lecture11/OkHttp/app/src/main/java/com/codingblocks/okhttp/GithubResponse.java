package com.codingblocks.okhttp;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GithubResponse {

    @SerializedName("total_count")
    private Integer totalCount;
    @SerializedName("incomplete_results")
    private Boolean incompleteResults;
    private ArrayList<GithubUser> items;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public ArrayList<GithubUser> getItems() {
        return items;
    }

    public void setItems(ArrayList<GithubUser> items) {
        this.items = items;
    }
}
