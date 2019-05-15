package com.xiaox.studydemo.aboutBinder;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

/**
 * 客户端代码
 */
public class Client extends AppCompatActivity {

    Intent intent = new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent.setComponent(new ComponentName("com.xiaox.studydemo.aboutBinder", "com.xiaox.studydemo.aboutBinder.Service"));
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IPlusInterface plus = IPlusInterface.Stub.asInterface(service);
                try {
                    int result = plus.add(1, 2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
    }


}
