package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/6/5
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class PrintMinNumber {


    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        PrintMinNumber(numbers);

    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
     *
     * 思路：依次对比数组中的数字中的首位、第二位、第三位...首位相等则比较第二位，找出小的数来，拼到结果里，
     * 这样所得的即是题目所要求的结果
     * 利用 String 来比较
     *
     */
    public static String PrintMinNumber(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String num1 = o1 + o2;
                String num2 = o2 + o1;
                return num1.compareTo(num2);
            }
        });
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString();
    }


    public static void compare(ArrayList<String> list) {
        list.sort(new Comparator<String>() {
            /**
             * @param s1 the first object to be compared.
             * @param s2 the second object to be compared.
             * 这个排序咋拍的哦？？
             */
            @Override
            public int compare(String s1, String s2) {
                // 排序后：a, ab, abc, acd, d, def

                // 排序前：acd, a, abc, d, ab, def

                // s1 = a    s1 = abc  s1 = abc  s1 = abc  s1 = d    s1 = d    s1 = ab   s1 = ab   s1 = ab  s1 = def  s1 = def
                // s2 = acd  s2 = a    s2 = acd  s2 = a    s2 = abc  s2 = acd  s2 = acd  s2 = abc  s2 = a   s2 = abc  s2 = d

                System.out.println("s1 = " + s1);
                System.out.println("s2 = " + s2);
                return s1.compareTo(s2);
            }
        });
    }

}
