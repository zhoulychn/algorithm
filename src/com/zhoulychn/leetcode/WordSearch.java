package com.zhoulychn.leetcode;



/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
 */

public class WordSearch {

    private boolean exist(char[][] board, String word) {

        int length = word.length();

        if (length == 0) return true;

        //定义出行与列
        int row = board.length;
        int col = board[0].length;

        //被使用过的单元格不再使用
        int[][] visited = new int[row][col];


        //遍历每一个点作为初始点，进行搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (search(i, j, 0, word, board, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j, int pos, String word, char[][] board, int[][] visited) {

        int row = board.length;
        int col = board[0].length;
        boolean flag = false;

        if (board[i][j] == word.charAt(pos)) {
            visited[i][j] = 1;

            if (++pos == word.length()) return true;
            if (i + 1 < row && visited[i + 1][j] == 0) {
                flag = search(i + 1, j, pos, word, board, visited);
            }
            if (i - 1 >= 0 && visited[i - 1][j] == 0) {
                flag = flag || search(i - 1, j, pos, word, board, visited);
            }
            if (j + 1 < col && visited[i][j + 1] == 0) {
                flag = flag || search(i, j + 1, pos, word, board, visited);
            }
            if (j - 1 >= 0 && visited[i][j - 1] == 0) {
                flag = flag || search(i, j - 1, pos, word, board, visited);
            }
            if (!flag) {
                visited[i][j] = 0;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'c', 'a', 'a'}, {'a', 'a', 'a'}, {'b', 'c', 'd'}};
        String word = "aab";
        System.out.println(new WordSearch().exist(board, word));
    }
}
