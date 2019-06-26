package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @Description: "student a am I"  ->  "I am a student"
 * @date 2019/6/26
 * @author:xiaox
 */
public class ReverseSentence {


    public static void main(String[] args) {
        String str = "student a are you";
        String s = reverseSentence1(str);
        System.out.println(s);
    }

    public static String ReverseSentence(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString();
    }


    /**
     * 算法思路：先翻转整个句子，然后，依次翻转每个单词。
     * 依据空格来确定单词的起始和终止位置
     */
    public static String reverseSentence1(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        //记录每个空格的位置
        int index = -1;
        for (int i = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                //遇到空格要从空格后的第一位开始翻转，所以+1
                reverse(chars, index + 1, i - 1);
                index = i;
            }
        }
        //处理最后一个单词
        reverse(chars, index + 1, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] arrays, int start, int end) {
        while (start < end) {
            char c = arrays[start];
            arrays[start] = arrays[end];
            arrays[end] = c;
            start++;
            end--;
        }
    }


}
