package com.express.gitanalyser.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.express.gitanalyser.R;
import com.express.gitanalyser.adapter.ContributorListAdapter;
import com.express.gitanalyser.model.RepositoryItem;

import butterknife.ButterKnife;

/**
 * Created by root on 5/12/17.
 */

public class ContributorListView extends RelativeLayout {

    ContributorListAdapter mContributorListAdapter;
    RepositoryItem mRepositoryItem;

    public ContributorListView(Context context) {
        this(context, null);
    }

    public ContributorListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    void initView(Context context) {
        inflate(context, R.layout.snippet_contributor_listivew, this);
        ButterKnife.bind(this);
        mContributorListAdapter = new ContributorListAdapter();
    }

    public void setRepositoryData(RepositoryItem repositoryItem) {
        mRepositoryItem = repositoryItem;
    }
}
