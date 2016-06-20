package com.example.m.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by m on 2016-06-20.
 */
public class DetailsActivity extends AppCompatActivity




{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;



        }

        if(savedInstanceState==null){
            DetailsFragment details = new DetailsFragment();
          details.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content,details).commit();
        }
    }
}
