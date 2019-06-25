package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @Description: 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @date 2019/6/25
 * @author:xiaox
 */
public class LeftRotateString {

    public static void main(String[] args) {
        String str = "abcXYZdef";
        LeftRotateString2(str, 3);
    }


    public static String LeftRotateString(String str, int n) {
        if (n < 0 || n > str.length()) {
            return str;
        }
        String substring = str.substring(0, n);
        String substring1 = str.substring(n, str.length());
        return substring1 + substring;
    }


    /**
     * 将字符串再拼接一次，从在裁剪从n 到 str最初的length
     */
    public static String LeftRotateString1(String str, int n) {
        int len = str.length();
        if (len == 0)
            return "";
        n = n % len;
        str += str;
        return str.substring(n, len);
    }


    /**
     * abcXYZdef
     * 3
     *
     * 原理：YX = (XTYT)T
     * 将X旋转之后再将Y旋转，最后再整体旋转
     */
    public static String LeftRotateString2(String str, int n) {
        if (n > str.length())
            return "";
        char[] charArray = str.toCharArray();
        reverse(charArray, 0, n - 1);//cbaXYZdef
        reverse(charArray, n, str.length() - 1);//cbafedZYX
        reverse(charArray, 0, str.length() - 1);//XYZdefabc
        return String.valueOf(charArray);
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
