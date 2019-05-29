package com.xiaox.studydemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiaox.studydemo.aboutBinder.Client;
import com.xiaox.studydemo.aboutDownload.DownloadActivty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent mIntent;
    public static final String TAG = "xiaoTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent();
        findViewById(R.id.btn_mvvm).setOnClickListener(this);
        findViewById(R.id.btn_binder).setOnClickListener(this);
        findViewById(R.id.btn_down).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mvvm:
                sendNotification();
                break;
            case R.id.btn_binder:
                mIntent.setClass(MainActivity.this, Client.class);
                startActivity(mIntent);
                break;
            case R.id.btn_down:
                mIntent.setClass(MainActivity.this, DownloadActivty.class);
                startActivity(mIntent);
                break;

        }
    }

    private void sendNotification() {
        //1、NotificationManager
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        /** 2、Builder->Notification
         *  必要属性有三项
         *  小图标，通过 setSmallIcon() 方法设置
         *  标题，通过 setContentTitle() 方法设置
         *  内容，通过 setContentText() 方法设置*/
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentInfo("Content info")
                .setContentText("Content text")//设置通知内容
                .setContentTitle("Content title")//设置通知标题
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setSmallIcon(R.mipmap.ic_launcher_round)//不能缺少的一个属性
                .setSubText("Subtext")
                .setTicker("滚动消息......")
                .setWhen(System.currentTimeMillis());//设置通知时间，默认为系统发出通知的时间，通常不用设置
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("001", "my_channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true); //是否在桌面icon右上角展示小红点
            channel.setLightColor(Color.GREEN); //小红点颜色
            channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
            manager.createNotificationChannel(channel);
            builder.setChannelId("001");
        }
        Notification n = builder.build();
        //3、manager.notify()
        manager.notify(1001, n);
    }
}
