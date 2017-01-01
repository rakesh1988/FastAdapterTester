package com.rakesh1988.fastadaptertester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{

    @OnClick(R.id.btn_for_fun)
    public void btnForFunClick()
    {
        Intent rvIntent = new Intent(this, RvHolder.class);
        startActivity(rvIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
