package com.express.gitanalyser.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    @SerializedName("owner")
    private RepositoryOwner mRepositoryOwner;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("contributors_url")
    private String mContributorUrl;

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

    public RepositoryOwner getmRepositoryOwner() {
        return mRepositoryOwner;
    }

    public String getContributorUrl() {
        return mContributorUrl;
    }

    public String getDescription() {
        return mDescription;
    }
}
