package com.图;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/22 9:14
 */

public class Demo_130被围绕的区域_DFS {
    public static void main(String[] args) {
        char[][] chars = {{'X', 'O', 'X', 'X'},
                        {'O', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'O'},
                        {'O', 'X', 'O', 'X'}};
        new Demo_130被围绕的区域_DFS().solve(chars);
        System.out.println(Arrays.deepToString(chars));
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] == 'X' || board[i][j] == '#') return;
        board[i][j] = '#';
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);

    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }


}
