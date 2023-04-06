package com.回溯;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/31 23:24
 */
public class Demo_52N皇后II {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    static int count = 0;
    static int [] path;
    static int index = 0;

    public static int totalNQueens(int n) {
        path =  new int[n];
        backtrack(n,0);
        return count;
    }

    public static void backtrack(int n,int nowRow) {
        if (nowRow==n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isCan(i,nowRow)){
                continue;
            }
            path[index++]=i;
            backtrack(n,nowRow+1);
            index--;
        }
    }

    private static boolean isCan(int i,int nowRow) {
        for (int j = 0; j < index; j++) {
            if (i==path[j]||nowRow-j==Math.abs(i-path[j])){
                return false;
            }
        }
        return true;
    }

}
