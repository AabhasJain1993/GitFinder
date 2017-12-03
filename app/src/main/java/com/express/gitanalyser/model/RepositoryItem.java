package com.express.gitanalyser.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 29/11/17.
 */

public class RepositoryItem implements Parcelable {

    private RepositoryItem() {

    }
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

    @SerializedName("html_url")
    private String mRepoUrl;

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

    public String getRepositoryUrl() {
        return mRepoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mFullName);
        dest.writeString(mDescription);
        dest.writeString(mWatchCount);
        dest.writeString(mCommitCount);
        dest.writeString(mContributorUrl);
        dest.writeParcelable(mRepositoryOwner, flags);
        dest.writeString(mRepoUrl);
    }

    public RepositoryItem(Parcel in){
        mName = in.readString();
        mFullName = in.readString();
        mDescription = in.readString();
        mWatchCount = in.readString();
        mCommitCount = in.readString();
        mContributorUrl = in.readString();
        mRepositoryOwner = in.readParcelable(RepositoryOwner.class.getClassLoader());
        mRepoUrl = in.readString();
    }

    public static final Parcelable.Creator<RepositoryItem> CREATOR = new Parcelable.Creator<RepositoryItem>() {
        public RepositoryItem createFromParcel(Parcel in) {
            return new RepositoryItem(in);
        }

        public RepositoryItem[] newArray(int size) {
            return new RepositoryItem[size];
        }
    };
}
