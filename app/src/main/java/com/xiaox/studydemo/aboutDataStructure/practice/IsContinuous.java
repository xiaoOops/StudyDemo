package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
 * “So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0
 *
 * @Description: 判断5张牌里是顺子，0可以当做癞子
 * @author:xiaox
 */
public class IsContinuous {


    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 0};
        isContinuous(numbers);
    }

    /**
     * max 记录 最大值
     * min 记录  最小值
     * min ,max 都不记0
     * 要满足顺子需要满足条件 1.max - min <5; 2.除0外没有重复的数字(牌) ;3.数组长度为5
     */
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        //用一个数组装1-10已经J,Q,K的牌，大小王表示为0
        int[] allCards = new int[14];
        int max = -1;
        int min = 14;
        for (int i = 0; i < numbers.length; i++) {
            //记录每张牌出现的次数
            allCards[numbers[i]]++;
            //大小王不计算出现次数
            if (numbers[i] == 0) {
                continue;
            }
            //如果有牌出现2次，直接返回false
            if (allCards[numbers[i]] > 1) {
                return false;
            }
            if (max < numbers[i]) {
                max = numbers[i];
            }
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return max - min < 5;
    }

}




































