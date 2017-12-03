package com.express.gitanalyser.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import retrofit.http.Url;

/**
 * Created by root on 1/12/17.
 */

public class RepositoryOwner implements Parcelable{

    private RepositoryOwner() {

    }
    @SerializedName("avatar_url")
    String mUserProfilePic;

    @SerializedName("login")
    String mRepositoryOwnerName;

    @SerializedName("repos_url")
    String mRepositoryUrl;

    public String getUserProfilePicUrl() {
        return mUserProfilePic;
    }

    public String getRepistoryOwnerName() {
        return mRepositoryOwnerName;
    }

    public String getRepositoryUrl() {
        return mRepositoryUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUserProfilePic);
        dest.writeString(mRepositoryOwnerName);
        dest.writeString(mRepositoryUrl);
    }

    public RepositoryOwner(Parcel in){
        mUserProfilePic = in.readString();
        mRepositoryOwnerName = in.readString();
        mRepositoryUrl = in.readString();
    }

    public static final Parcelable.Creator<RepositoryOwner> CREATOR = new Parcelable.Creator<RepositoryOwner>() {
        public RepositoryOwner createFromParcel(Parcel in) {
            return new RepositoryOwner(in);
        }

        public RepositoryOwner[] newArray(int size) {
            return new RepositoryOwner[size];
        }
    };
}
