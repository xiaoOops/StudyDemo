package com.xiaox.studydemo.aboutBinder;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.xiaox.studydemo.Book;
import com.xiaox.studydemo.IPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务端代码
 */
public class Service extends android.app.Service {

    IPlus.Stub mStub = new IPlus.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int getResult(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public Map getMap() throws RemoteException {
            HashMap<String, String> map = new HashMap<>();
            map.put("123", "ahaha");
            return map;
        }

        @Override
        public List<Book> getList() throws RemoteException {
            ArrayList<Book> books = new ArrayList<>();
            books.add(new Book(666, "金瓶梅"));
            return books;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mStub;
    }
}
