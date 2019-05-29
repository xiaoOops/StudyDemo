package com.xiaox.studydemo;

import com.xiaox.studydemo.aboutDataStructure.LinkedList.SingleLinkedList;
import com.xiaox.studydemo.aboutDataStructure.SimpleList;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/5/24
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class Test {

    public static void main(String[] arg) {
        //        int MODE_SHIFT = 30;
        //        int MODE_MASK = 0x3 << MODE_SHIFT;
        //        System.out.println(MODE_MASK);


        checkSingleList();

    }


    private static void checkSingleList() {
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.insertNodeByIndex(666, 4);
        //list.delNodeByIndex(1);
        System.out.println(list.toString());
        System.out.println("size =" + list.size());
    }

    private static void checkSimpleList() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        list.delete(1);
        list.insert(99, 0);

        System.out.println(list.toString());


    }
}
