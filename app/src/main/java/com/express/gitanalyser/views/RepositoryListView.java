package com.express.gitanalyser.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.express.gitanalyser.R;
import com.express.gitanalyser.adapter.RepositoryListAdapter;
import com.express.gitanalyser.api.APIClient;
import com.express.gitanalyser.api.RepositoryAPI;
import com.express.gitanalyser.interfaces.IRepositoryClickListener;
import com.express.gitanalyser.model.Repository;
import com.express.gitanalyser.model.RepositoryItem;

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

public class RepositoryListView extends RelativeLayout implements IRepositoryClickListener{

    @Bind(R.id.repo_list)
    RecyclerView mRepoListView;
    RepositoryListView mRepositoryListView;

    private RepositoryListAdapter mRepositoryListAdapter;
    private RepositoryAPI mAPIInterface;
    private List<RepositoryItem> repositoryItemList;
    private Listener mListener = null;

    public interface Listener {
        void onRepositorySelected(RepositoryItem repositoryItem);
    }

    public RepositoryListView(Context context) {
        this(context,null);
    }

    public RepositoryListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    void initView(Context context) {
        inflate(context, R.layout.snippet_repository_listview, this);
        ButterKnife.bind(this);

        mRepositoryListView = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRepoListView.setLayoutManager(linearLayoutManager);

        setDataFromAPI();
    }

    void setDataFromAPI() {


        mAPIInterface = APIClient.getInstance().create(RepositoryAPI.class);

        Call<Repository> call =  mAPIInterface.repositoryList("retrofit");

        call.enqueue(new Callback<Repository>() {
            List<RepositoryItem> list ;
            @Override
            public void onResponse(Response<Repository> response, Retrofit retrofit) {
                //Log.d("Success : ", response.body().getCount() + "");
                if(response.body().getCount()>10)
                    repositoryItemList = response.body().getRepositoryItemList().subList(0,11);
                else
                    repositoryItemList = response.body().getRepositoryItemList();

                mRepositoryListAdapter = new RepositoryListAdapter(mRepositoryListView, repositoryItemList);
                mRepoListView.setAdapter(mRepositoryListAdapter);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Failure : ", "Failure");
            }
        });

    }

    @Override
    public void onRepositoryClick(int position) {
         if(mListener !=null) {
             mListener.onRepositorySelected(repositoryItemList.get(position));
         }
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }
}
