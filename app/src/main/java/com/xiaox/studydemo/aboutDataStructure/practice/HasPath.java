package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/7/13
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * <p>
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 */
public class HasPath {

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        boolean b = hasPath(matrix, 3, 4, new char[]{'a', 'b', 'c', 'b'});
        System.out.println(b);
    }

    /**
     * 核心思想：回溯法
     * 用一个状态数组保存之前访问过的字符，然后再分别按上，下，左，右递归
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        int[] visited = new int[matrix.length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (help(matrix, rows, cols, row, col, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean help(char[] matrix, int rows, int cols, int row, int col, char[] str, int strIndex, int[] visited) {
        //先找到当前字母在数组中的位置
        int index = row * cols + col;
        if (row < 0 || row > rows || col < 0 || col >= cols || matrix[index] != str[strIndex] || visited[index] == 1) {
            //说明没找到，需要回溯到上一层
            return false;
        }
        if (strIndex == str.length - 1) {
            //递归遍历完了
            return true;
        }
        //标记走过的路线，因为不能走回头路
        visited[index] = 1;
        //找到匹配的再分别从上下左右去递归找
        if (help(matrix, rows, cols, row - 1, col, str, strIndex + 1, visited) ||
                help(matrix, rows, cols, row + 1, col, str, strIndex + 1, visited) ||
                help(matrix, rows, cols, row, col - 1, str, strIndex + 1, visited) ||
                help(matrix, rows, cols, row, col + 1, str, strIndex + 1, visited)) {
            return true;
        }
        //如果遍历完所有的可能都没有找到路径，将标记过的路径清零
        visited[index] = 0;
        return false;
    }


}
