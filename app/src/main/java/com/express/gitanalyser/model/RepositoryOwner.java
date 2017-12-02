package com.express.gitanalyser.model;

import com.google.gson.annotations.SerializedName;

import retrofit.http.Url;

/**
 * Created by root on 1/12/17.
 */

public class RepositoryOwner {

    @SerializedName("avatar_url")
    String mUserProfilePic;

    @SerializedName("login")
    String mRepositoryOwnerName;

    public String getUserProfilePicUrl() {
        return mUserProfilePic;
    }

    public String getRepistoryOwnerName() {
        return mRepositoryOwnerName;
    }
}
