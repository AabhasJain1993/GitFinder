package com.express.gitanalyser.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/12/17.
 */

public class Contributor {

    @SerializedName("login")
    String mContributorName;

    @SerializedName("contributions")
    int mContributions;

    @SerializedName("avatar_url")
    String mAvatarUrl;

    public String getContributorName() {
        return mContributorName;
    }

    public int getContributions() {
        return mContributions;
    }

    public String getContributorUrl() {
        return mAvatarUrl;
    }
}
