package com.xiaox.studydemo.aboutDataStructure.listStudy;

/**
 * @version V1.0
 * @Title: Loan
 * @Description: 简单实现单链表的数据结构
 * @date 2019/5/29
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class SingleLinkedList {

    private int size;
    private Node last;
    private Node first;

    public void add(int data) {
        //默认总是插入到链表最后
        Node l = last;
        Node newNode = new Node(data, null);
        last = newNode;
        if (l == null) {
            //说明此时list是空的，添加进来的data是第一个数据
            first = newNode;
        } else {
            //说明list已经有数据了，将data放到最后，调整指针
            l.next = newNode;
        }
        size++;
    }

    /**
     * 插入结点到链表的指定位置
     *
     * @param data
     * @param index
     */
    public void insertNodeByIndex(int data, int index) {
        if (!isElementIndex(index)) {
            return;
        }
        Node newNode = new Node(data, null);
        int length = 0;
        Node temp = first;
        while (temp.next != null) {
            if (index == 0) {
                //处理特殊位置
                newNode.next = first;
                first = newNode;
                size++;
                return;
            } else if (index == ++length) {
                //找到要插入的位置,调整指针
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除指定位置的节点
     */
    public void delNodeByIndex(int index) {
        if (!isElementIndex(index)) {
            return;
        }
        Node temp = first;
        int length = 0;
        while (temp.next != null) {
            if (index == 0) {
                //处理特殊位置
                first = first.next;
                size--;
                return;
            } else if (index == ++length) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 全部删除
     */
    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.data = 0;
            x.next = null;
            x = next;
        }
        size = 0;
        first = last = null;
    }


    /**
     * 获取对应位置的节点
     */
    public int get(int index) {
        if (!isElementIndex(index)) {
            return -1;
        }
        Node node = first;
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                result = node.data;
                break;
            }
            node = node.next;
        }
        return result;
    }

    /*
        源码实现，判断index大小，小于size的一半，就从first开始遍历
        大于size的一半，就从last开始遍历
        Node<E> node(int index) {
            // assert isElementIndex(index);

            if (index < (size >> 1)) {
                Node<E> x = first;
                for (int i = 0; i < index; i++)
                    x = x.next;
                return x;
            } else {
                Node<E> x = last;
                for (int i = size - 1; i > index; i--)
                    x = x.prev;
                return x;
            }
        }
    */

    public int size() {
        return size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    private static class Node {

        int data;
        //指针，指向下一个node,默认为null
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = first;
        if (first != null) {
            sb.append(first.data + ", ");
            while (temp.next != null) {
                temp = temp.next;
                sb.append(temp.data + ", ");
            }
        }
        return "SingleLinkedList{ " + sb.toString() + "}";
    }
}
