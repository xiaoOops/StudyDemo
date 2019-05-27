package com.xiaox.studydemo.aboutDataStructure;

import java.util.Arrays;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/5/27
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class SimpleList {

    private Object[] origin;
    private int size;

    public SimpleList() {
        origin = new Object[10];
        size = 0;
    }

    public Object add(Object ele) {
        if (size > origin.length) {
            return null;
        }
        origin[size] = ele;
        size++;
        return ele;
    }

    public void insert(Object ele, int index) {
        if (index > size - 1) {
            return;
        }
        //倒序，从插入的位置开始，每一位都向后移一位
        for (int i = size - index - 1; i > 0; i--) {
            origin[i] = origin[i - 1];
        }
        origin[index] = ele;
    }


    public Object delete(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Object o = origin[index];
        for (int i = index; i < size - 1; i++) {
            origin[i] = origin[i + 1];
        }
        origin[size - 1] = null;
        return o;

    }


    @Override
    public String toString() {
        return "SimpleList{" +
                "origin=" + Arrays.toString(origin) +
                ", index=" + size +
                '}';
    }
}
