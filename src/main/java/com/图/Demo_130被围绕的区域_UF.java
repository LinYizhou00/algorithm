package com.图;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/22 9:42
 */
public class Demo_130被围绕的区域_UF {
    public static void main(String[] args) {
        char[][] chars = {{'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}};
        new Demo_130被围绕的区域_UF().solve(chars);
        System.out.println(Arrays.deepToString(chars));
    }

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        UF uf = new UF(n * m + 1);
        int dummy = n * m;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') uf.union(dummy, i * m);
            if (board[i][m - 1] == 'O') uf.union(dummy, i * m + m - 1);
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') uf.union(dummy, i);
            if (board[n - 1][i] == 'O') uf.union(dummy, (n - 1) * m + i);
        }
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < d.length; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(x * m + y, i * m + j);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 'O' && !uf.isConnect(dummy, i * m + j)) {
                    board[i][j] = 'X';

                }
            }
        }
    }


}
