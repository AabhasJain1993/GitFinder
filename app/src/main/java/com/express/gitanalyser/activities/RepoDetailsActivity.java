package com.express.gitanalyser.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.express.gitanalyser.R;
import com.express.gitanalyser.adapter.ContributorListAdapter;
import com.express.gitanalyser.model.RepositoryItem;
import com.express.gitanalyser.views.ContributorListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by root on 30/11/17.
 */

public class RepoDetailsActivity extends AppCompatActivity {

    @Bind(R.id.repodetails_image)
    ImageView mRepoOwnerImage;

    @Bind(R.id.repoDetails_nameValue)
    TextView mName;

    @Bind(R.id.repoDetails_linkValue)
    TextView mProjectLink;

    @Bind(R.id.repoDetails_descriptionValue)
    TextView mDescription;

    @Bind(R.id.repoDetails_contributorValue)
    TextView mContributors;

    @Bind(R.id.contributor_listview)
    ContributorListView mContributorList;

    private RepositoryItem mRepositoryItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repodetails);
        ButterKnife.bind(this);

        mRepositoryItem = getIntent().getParcelableExtra("RepositoryItemData");

        mContributorList.setRepositoryData(mRepositoryItem);

        setData();

    }

    void setData() {
        Glide.with(this).load(mRepositoryItem.getmRepositoryOwner().getUserProfilePicUrl()).into(mRepoOwnerImage);
        mName.setText(mRepositoryItem.getName());
        mProjectLink.setText(mRepositoryItem.getRepositoryUrl());
        mDescription.setText(mRepositoryItem.getDescription());
    }



}
