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
        System.out.println(replaceSpace(stringBuffer));
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
}
