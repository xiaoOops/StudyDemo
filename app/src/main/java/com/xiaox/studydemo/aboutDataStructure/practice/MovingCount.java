package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/7/15
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class MovingCount {

    public static void main(String[] args) {
        movingCount(15,10,10);
    }


    public static int movingCount(int threshold, int rows, int cols) {

        int[][] visited = new int[rows][cols];

        return helper(0, 0, rows, cols, visited, threshold);

    }

    private static int helper(int row, int col, int rows, int cols, int[][] visited, int threshold) {
        if (row < 0 || row >= rows || col < 0 || col >= cols ||
                getSum(row) + getSum(col) > threshold ||
                visited[row][col] == 1) {
            return 0;
        }
        visited[row][col] = 1;
        return helper(row - 1, col, rows, cols, visited, threshold)
                + helper(row + 1, col, rows, cols, visited, threshold)
                + helper(row, col - 1, rows, cols, visited, threshold)
                + helper(row, col + 1, rows, cols, visited, threshold)
                + 1;
    }

    private static int getSum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }

}
