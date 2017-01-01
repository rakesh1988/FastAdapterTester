package com.rakesh1988.fastadaptertester;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.rakesh1988.fastadaptertester.api.GithubApiHelper;
import com.rakesh1988.fastadaptertester.model.GithubUser;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RvHolder extends AppCompatActivity
{
    @BindView(R.id.rv_github_user)
    RecyclerView rvGithubUser;

    FastItemAdapter<IItem> mFastAdapter = new FastItemAdapter<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_holder);
        ButterKnife.bind(this);

        rvGithubUser.setHasFixedSize(true);
        rvGithubUser.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvGithubUser.setItemAnimator(new DefaultItemAnimator());
        rvGithubUser.setAdapter(mFastAdapter);

        loadGithubUsers();
    }

    private void loadGithubUsers()
    {
        Call<List<GithubUser>> call = new GithubApiHelper().
                getGithubUsers();
        call.enqueue(new Callback<List<GithubUser>>()
        {
            @Override
            public void onResponse(Call<List<GithubUser>> call, Response<List<GithubUser>> response)
            {
                Log.d("","Calling API SU");
                for (GithubUser githubUser :
                        response.body())
                {
                    mFastAdapter.add(new GithubUserItem(githubUser));
                    Log.d("","adding item");
                }

            }

            @Override
            public void onFailure(Call<List<GithubUser>> call, Throwable t)
            {
                Log.d("","Calling API FA");
            }
        });
    }

}
