package com.express.gitanalyser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.express.gitanalyser.R;
import com.express.gitanalyser.model.RepositoryItem;
import com.express.gitanalyser.views.RepositoryHolder;

import java.util.List;

/**
 * Created by root on 29/11/17.
 */

public class RepositoryListAdapter extends RecyclerView.Adapter<RepositoryHolder> {

    public static final String TAG= "REPOSITORY LIST ADAPTER";
    private List<RepositoryItem> mRepositoryItemList;


    public RepositoryListAdapter(List<RepositoryItem> list) {
        mRepositoryItemList = list;
    }

    @Override
    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.snippet_repository_card, parent, false);
        return new RepositoryHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(RepositoryHolder holder, int position) {
        RepositoryItem item = mRepositoryItemList.get(position);
        holder.bind(item.getName(), item.getFullName(), item.getWatchCount(), item.getCommitCount(), item.getmRepositoryOwner().getUserProfilePicUrl());
        //holder.itemView.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return mRepositoryItemList.size();
    }

}
