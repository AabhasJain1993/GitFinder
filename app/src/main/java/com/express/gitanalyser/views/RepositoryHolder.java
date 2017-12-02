package com.express.gitanalyser.views;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.express.gitanalyser.R;

/**
 * Created by root on 30/11/17.
 */

public class RepositoryHolder extends RecyclerView.ViewHolder {

    TextView mName, mFullName;
    TextView mWatcherCount, mCommitCount;

    ImageView mImageView;
    Context mContext;

    public RepositoryHolder(View view, Context context) {
        super(view);
        mName = (TextView) view.findViewById(R.id.nameValue);
        mFullName = (TextView)view.findViewById(R.id.fullnameValue);
        mWatcherCount = (TextView)view.findViewById(R.id.watchCountValue);
        mCommitCount = (TextView)view.findViewById(R.id.commitcountValue);
        mImageView =(ImageView)view.findViewById(R.id.repo_image);
        mContext = context;
    }

    public void bind(String name, String fullName, String watchCount, String commitCount, String url) {
        mName.setText(name);
        mFullName.setText(fullName);
        mWatcherCount.setText(watchCount);
        mCommitCount.setText(commitCount);
        Glide.with(mContext).load(url).into(mImageView);
    }

}
