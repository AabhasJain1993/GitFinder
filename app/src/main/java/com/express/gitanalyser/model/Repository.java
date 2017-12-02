package com.express.gitanalyser.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 1/12/17.
 */

public class Repository implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
