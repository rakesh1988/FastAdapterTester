package com.rakesh1988.fastadaptertester.api;

import com.rakesh1988.fastadaptertester.model.GithubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rakesh on 01-Jan-17.
 */

public interface GithubApi
{
    @GET("/users")
    Call<List<GithubUser>> getGithubUsers();
}
