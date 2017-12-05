package com.express.gitanalyser.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.express.gitanalyser.R;
import com.express.gitanalyser.model.Contributor;
import com.express.gitanalyser.model.RepositoryItem;

import java.util.List;

/**
 * Created by root on 5/12/17.
 */

public class ContributorListAdapter extends BaseAdapter {

    private List<Contributor> mContributorList;

    public ContributorListAdapter(List<Contributor> contributorList) {
        mContributorList = contributorList;
    }

    @Override
    public int getCount() {
        return mContributorList.size();
    }

    @Override
    public Object getItem(int position) {
        return mContributorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.snippet_repository_card, parent, false);
        return ;
    }
}
