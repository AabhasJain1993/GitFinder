package com.express.gitanalyser.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.express.gitanalyser.R;

/**
 * Created by root on 30/11/17.
 */

public class RepositoryHolder extends RecyclerView.ViewHolder {

    TextView mName, mFullName;
    TextView mWatcherCount, mCommitCount;

    ImageView mImageView;

    public RepositoryHolder(View view) {
        super(view);
        mName = (TextView) view.findViewById(R.id.nameValue);
        mFullName = (TextView)view.findViewById(R.id.fullnameValue);
        mWatcherCount = (TextView)view.findViewById(R.id.watchCountValue);
        mCommitCount = (TextView)view.findViewById(R.id.commitcountValue);
    }

    public void bind(String name, String fullName, String watchCount, String commitCount) {
        mName.setText(name);
        mFullName.setText(fullName);
        mWatcherCount.setText(watchCount);
        mCommitCount.setText(commitCount);
    }

}
