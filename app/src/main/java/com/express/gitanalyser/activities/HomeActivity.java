package com.express.gitanalyser.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.express.gitanalyser.adapter.RepositoryListAdapter;
import com.express.gitanalyser.model.APIClient;
import com.express.gitanalyser.model.RepositoryAPI;
import com.express.gitanalyser.model.RepositoryItem;

import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.express.gitanalyser.R;

import java.util.List;

import butterknife.Bind;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by root on 29/11/17.
 */

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private RepositoryListAdapter mRepositoryListAdapter;
    private RepositoryAPI mAPIInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mAPIInterface = APIClient.getInstance().create(RepositoryAPI.class);

        Call<List<RepositoryItem>> call =  mAPIInterface.repositoryList("retrofit");

        Log.d("Aabhas", "Aabhas");
        call.enqueue(new Callback<List<RepositoryItem>>() {
            @Override
            public void onResponse(Response<List<RepositoryItem>> response, Retrofit retrofit) {
                Log.d("Success : ", response.body().size() + "");
                List<RepositoryItem> list = response.body();
                mRepositoryListAdapter = new RepositoryListAdapter(list);
                mRecyclerView.setAdapter(mRepositoryListAdapter);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Failure : ", "Failure");
            }
        });

    }
}
