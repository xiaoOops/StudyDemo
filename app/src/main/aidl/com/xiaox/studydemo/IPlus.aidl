// IPlus.aidl
package com.xiaox.studydemo;

// Declare any non-default types here with import statements
import com.xiaox.studydemo.Book;

interface IPlus {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


    int getResult(int a ,int b);

    Map getMap();

    List<Book> getList();

}
