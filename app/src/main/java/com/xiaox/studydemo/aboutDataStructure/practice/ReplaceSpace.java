package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/5/31
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We Are Happy");
        System.out.println(replaceSpace1(stringBuffer));
    }


    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
     */
    public static String replaceSpace(StringBuffer str) {
        String content = str.toString();
        char[] chars = content.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isSpaceChar(chars[i])) {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /*
     *问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
     *问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
     *     从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
     *    从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
     */
    public static String replaceSpace1(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        //先计算字符串中的空格
        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        //替换后的字符串的长度
        int newStrLength = str.length() + spaceCount * 2;
        //旧str的指针
        int originIndex = str.length() - 1;
        //新str的指针
        int newIndex = newStrLength - 1;
        //使str的长度扩大到转换成%20之后的长度,防止下标越界
        str.setLength(newStrLength);
        //两个指针同时从后向前移动，遇到空格的话，旧指针向前移动1，新指针向前移动3，如果相遇，代表没有空格了
        while (originIndex > 0 && newIndex > 0 && newIndex > originIndex) {
            if (str.charAt(originIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(originIndex));
            }
            originIndex--;
        }
        return str.toString();
    }


}







