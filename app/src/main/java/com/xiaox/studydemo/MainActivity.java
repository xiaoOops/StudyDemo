package com.xiaox.studydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiaox.studydemo.aboutBinder.Client;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent();
        findViewById(R.id.btn_mvvm).setOnClickListener(this);
        findViewById(R.id.btn_binder).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mvvm:

                break;
            case R.id.btn_binder:
                mIntent.setClass(MainActivity.this, Client.class);
                startActivity(mIntent);
                break;

        }
    }
}
