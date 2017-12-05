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

    String getContributorName() {
        return mContributorName;
    }

    int getContributions() {
        return mContributions;
    }

    String getContributorUrl() {
        return mAvatarUrl;
    }
}
