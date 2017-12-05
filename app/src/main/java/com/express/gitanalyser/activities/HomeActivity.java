package com.express.gitanalyser.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.express.gitanalyser.adapter.RepositoryListAdapter;
import com.express.gitanalyser.api.APIClient;
import com.express.gitanalyser.interfaces.IRepositoryClickListener;
import com.express.gitanalyser.model.Repository;
import com.express.gitanalyser.api.RepositoryAPI;
import com.express.gitanalyser.model.RepositoryItem;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.express.gitanalyser.R;
import com.express.gitanalyser.views.RepositoryListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by root on 29/11/17.
 */

public class HomeActivity extends AppCompatActivity implements RepositoryListView.Listener{

    @Bind(R.id.repo_list_view)
    RepositoryListView mRepositoryListView;

    private Context mContext = getBaseContext();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mRepositoryListView.setListener(this);
    }

    @Override
    public void onRepositorySelected(RepositoryItem repositoryItem) {
        //Toast.makeText(this, "Repositroy item " + repositoryItem.getName(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,RepoDetailsActivity.class);
        intent.putExtra("RepositoryItemData", repositoryItem);
        startActivity(intent);
    }


}

