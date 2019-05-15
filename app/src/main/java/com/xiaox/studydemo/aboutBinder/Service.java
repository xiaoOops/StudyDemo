package com.xiaox.studydemo.aboutBinder;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * 服务端代码
 */
public class Service extends android.app.Service {

    IPlusInterface.Stub stub = new IPlusInterface.Stub() {
        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}
