package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *  在一个字符串(0 < = 字符串长度 < = 10000 ， 全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置,
 *  如果没有则返回 -1（需要区分大小写）
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        String str = "googole";
        System.out.println(FirstNotRepeatingChar1(str));
    }

    /**
     * 利用 LinkedHashMap 记录字母出现的顺序以及次数
     */
    public static int FirstNotRepeatingChar1(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap();
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i)) + 1;
                map.put(str.charAt(i), time);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                index = str.indexOf(entry.getKey());
                break;
            }
        }
        return index;
    }

    /**
     * 利用 int[] 的数组记录，相比较 LinkedHashMap ，int数组只需要记录次数，
     * 但是有空间浪费，需要提前创建一个 ‘ z ’长度的数组
     */
    public static int FirstNotRepeatingChar2(String str) {
        char[] chars = str.toCharArray();
        //创建一个 a - z 长度的数组
        int[] list = new int['z'];
        for (char c : chars) {
            // 找到字母对应数组中的位置，+1 记录出现次数
            list[(int) c]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (list[(int) chars[i]] == 1)
                return i;
        }
        return -1;
    }

}
