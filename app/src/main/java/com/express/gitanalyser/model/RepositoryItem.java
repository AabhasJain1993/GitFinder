package com.express.gitanalyser.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 29/11/17.
 */

public class RepositoryItem {

    @SerializedName("name")
    private String mName;

    @SerializedName("full_name")
    private String mFullName;

    @SerializedName("watchers_count")
    private String mWatchCount;

    @SerializedName("stargazers_count")
    private String mCommitCount;


    public String getName() {
        return mName;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getWatchCount() {
        return mWatchCount;
    }

    public String getCommitCount() {
        return mCommitCount;
    }
}
