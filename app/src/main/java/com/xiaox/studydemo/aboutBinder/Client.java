package com.xiaox.studydemo.aboutBinder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.xiaox.studydemo.Book;
import com.xiaox.studydemo.IPlus;
import com.xiaox.studydemo.R;

import java.util.List;
import java.util.Map;

/**
 * 客户端代码
 */
public class Client extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder);
        final Intent intent = new Intent(this, Service.class);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });

    }


    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                IPlus iPlus = IPlus.Stub.asInterface(service);
                int result = iPlus.getResult(1, 2);
                Map map = iPlus.getMap();
                List<Book> list = iPlus.getList();
                Log.i("xiaoTAG", "result = " + result);
                Log.i("xiaoTAG", "map = " + map.toString());
                Log.i("xiaoTAG", "list = " + list.toString());
                Log.i("xiaoTAG", "isMainLooper = "+ (Looper.myLooper()==Looper.getMainLooper()));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}
