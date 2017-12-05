package com.express.gitanalyser.api;

import com.express.gitanalyser.model.Contributor;
import com.express.gitanalyser.model.Repository;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.Url;

/**
 * Created by root on 30/11/17.
 */

public interface RepositoryAPI {

    @GET("search/repositories")
    Call<Repository> repositoryList(@Query("q") String queryField);

    @GET
    Call<List<Contributor>> contributorList(@Url String query);
}
