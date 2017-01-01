package com.rakesh1988.fastadaptertester.api;

import com.rakesh1988.fastadaptertester.model.GithubUser;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rakesh on 01-Jan-17.
 */

public class GithubApiHelper
{
    public static Retrofit retrofit()
    {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        OkHttpClient client = builder.build();
        return new Retrofit.Builder().
                baseUrl("https://api.github.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<List<GithubUser>> getGithubUsers()
    {
        GithubApi githubApi = retrofit().create(GithubApi.class);
        return githubApi.getGithubUsers();
    }

}
