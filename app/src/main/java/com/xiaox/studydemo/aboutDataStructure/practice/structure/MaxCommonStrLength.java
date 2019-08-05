package com.xiaox.studydemo.aboutDataStructure.practice.structure;

/**
 * @date 2019/7/18
 * 求2个字符串的最大公共子串的长度
 */
public class MaxCommonStrLength {

    public static void main(String[] args) {
        String str1 = "fgabced";
        String str2 = "dfcdefg1";
        System.out.println(maxCommonLength(str1, str2));
    }


    /**
     * 通过从A的第一个字符开始与B对应的每一个字符进行对比的方式找到最长的公共字串。
     * 如果此时没有找到匹的字母，则移动到A的第二个字符处，然后从B的第一个字符处进行对比，以此类推
     */
    private static int maxCommonLength(String str1, String str2) {
        int maxLength = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    // 继续比较后面的字符
                    int k = 1;
                    while (i + k < str1.length() && j + k < str2.length() &&
                            str1.charAt(i + k) == str2.charAt(j + k)) {
                        k++;
                    }
                    // 如果 k 大于 最长 字符串
                    if (k > maxLength) {
                        // 公共 子串 长度
                        maxLength = k;
                    }
                }
            }
        }
        return maxLength;
    }

}

























