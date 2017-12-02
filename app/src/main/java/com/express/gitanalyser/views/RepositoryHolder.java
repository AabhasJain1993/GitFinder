package com.express.gitanalyser.views;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.express.gitanalyser.R;
import com.express.gitanalyser.interfaces.IRepositoryClickListener;

/**
 * Created by root on 30/11/17.
 */

public class RepositoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView mName, mFullName;
    TextView mWatcherCount, mCommitCount;
    ImageView mImageView;
    Context mContext;
    IRepositoryClickListener mRepositoryClickListener = null;

    public RepositoryHolder(View view, IRepositoryClickListener iRepositoryClickListener) {
        super(view);
        mName = (TextView) view.findViewById(R.id.nameValue);
        mFullName = (TextView)view.findViewById(R.id.fullnameValue);
        mWatcherCount = (TextView)view.findViewById(R.id.watchCountValue);
        mCommitCount = (TextView)view.findViewById(R.id.commitcountValue);
        mImageView =(ImageView)view.findViewById(R.id.repo_image);
        mContext = view.getContext();
        itemView.setOnClickListener(this);
        mRepositoryClickListener = iRepositoryClickListener;
    }

    public void bind(String name, String fullName, String watchCount, String commitCount, String url) {
        mName.setText(name);
        mFullName.setText(fullName);
        mWatcherCount.setText(watchCount);
        mCommitCount.setText(commitCount);
        Glide.with(mContext).load(url).into(mImageView);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if(mRepositoryClickListener !=null)
            mRepositoryClickListener.onRepositoryClick(position);
        else
            Toast.makeText(mContext, "Null click Listener", Toast.LENGTH_LONG).show();

    }
}
