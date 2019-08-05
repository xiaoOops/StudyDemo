package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/7/9
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {

    public static void main(String[] args) {
        int[][] array = new int[4][4];
        array[0] = new int[]{1, 2, 8, 9};
        array[1] = new int[]{4, 7, 10, 13};
        //array[2] = new int[]{4, 7, 10, 13};
        //array[3] = new int[]{6, 8, 11, 15};

        boolean b = find(7, array);
        System.out.println(b);
    }


    /**
     * 首先选取数组右上角的数字，如果该数字大于目标，则说明该数字所在的这一列都大于目标，排除这一列，继续从倒数第二列开始找
     * 如果该数字小于该目标，则说明该数字所在的行都小于目标，排除这一行，继续向下一行找
     * 重复这样的操作，直到找到目标数字或者遍历完整个数组
     */
    public static boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length != array.length) {
            return false;
        }
        boolean result = false;
        int rows = 0;//行
        int cols = array[rows].length - 1;//列
        int number;
        while (rows < array.length - 1 && cols >= 0) {
            number = array[rows][cols];
            if (target == number) {
                result = true;
                break;
            } else if (target < number) {
                cols--;
            } else {
                rows++;
            }
        }
        return result;
    }
}




























