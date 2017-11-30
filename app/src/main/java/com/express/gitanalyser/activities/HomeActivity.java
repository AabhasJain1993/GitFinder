package com.express.gitanalyser.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.express.gitanalyser.adapter.RepositoryListAdapter;
import com.google.gson.Gson;
import android.support.v7.widget.RecyclerView;


import com.express.gitanalyser.R;

import butterknife.Bind;

/**
 * Created by root on 29/11/17.
 */

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private RepositoryListAdapter mRepositoryListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Iniitialize repository List Adapter
        mRecyclerView.setAdapter(mRepositoryListAdapter);
    }
}
