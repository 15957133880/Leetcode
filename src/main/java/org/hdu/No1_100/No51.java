package org.hdu.No1_100;

import java.util.*;

public class No51 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public static void main(String[] args) {
        No51 no51 = new No51();
        List<List<String>> lists = no51.solveNQueens(4);
        char c1 = '5';
        char c2 = '5';
        c1++;
        System.out.println(c1 );


    }
    public List<List<String>> solveNQueens(int n) {
        char[][] charss = new char[n][n];
        for (char[] chars : charss) {
            Arrays.fill(chars, '.');
        }
        backtrace(charss, 0);
        return res;
    }

    void backtrace(char[][] charss, int row) {
        int n = charss.length;
        if (row == n) {
            res.add(new ArrayList<String>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(charss, row, col)) {
                charss[row][col] = 'Q';
                path.add(String.valueOf(charss[row]));
                backtrace(charss, row + 1);
                charss[row][col] = '.';
                path.remove(path.size() - 1);
            }
        }

    }

    boolean isValid(char[][] charss, int i, int j) {
        int n = charss.length;
        //检查当前行
        for (int t = 0; t < j; t++) {
            if (charss[i][t] == 'Q') {
                return false;
            }
        }
        //检查当前列
        int s = i, t = j;
        while (s >= 0) {
            if (charss[s][t] == 'Q') {
                return false;
            }
            s--;
        }

        //检查左上角
        s = i;
        t = j;
        while (s >= 0 && t >= 0) {
            if (charss[s][t] == 'Q') {
                return false;
            }
            s--;
            t--;
        }
        //检查右上角
        s = i;
        t = j;
        while (s >= 0 && t < n) {
            if (charss[s][t] == 'Q') {
                return false;
            }
            s--;
            t++;
        }
        return true;
    }
}


