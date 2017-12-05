package com.express.gitanalyser.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.express.gitanalyser.R;
import com.express.gitanalyser.adapter.ContributorListAdapter;
import com.express.gitanalyser.api.RepositoryAPI;
import com.express.gitanalyser.model.Contributor;
import com.express.gitanalyser.model.RepositoryItem;
import com.express.gitanalyser.utils.ApiHelper;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by root on 5/12/17.
 */

public class ContributorListView extends RelativeLayout {

    ContributorListAdapter mContributorListAdapter;
    List<Contributor> mContributorsList;

    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

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
    }

    public void setRepositoryData(final RepositoryItem repositoryItem) {

        String url = repositoryItem.getContributorUrl();
        Call<List<Contributor>> call = ApiHelper.getAPInterface().contributorList(url);
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Response<List<Contributor>> response, Retrofit retrofit) {
                mContributorsList = response.body();
                mContributorListAdapter = new ContributorListAdapter(repositoryItem);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
