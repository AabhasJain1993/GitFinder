package com.express.gitanalyser.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 1/12/17.
 */

public class Repository {

    @SerializedName("total_count")
    int count;

    @SerializedName("incomplete_results")
    boolean ifResultsIncomplete;

    @SerializedName("items")
    List<RepositoryItem> repositoryItemList;

    public int getCount() {
        return count;
    }

    public boolean checkResultsStatus() {
        return ifResultsIncomplete;
    }

    public List<RepositoryItem> getRepositoryItemList() {
        return repositoryItemList;
    }
}
