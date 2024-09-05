package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {
    static int n;
    static char[][] board;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];

        sb = new StringBuilder();

        star(0, 0, n, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    static void star(int a, int b, int size, boolean isBlank) {
        if (isBlank) {
            for (int i = a; i < a + size; i++) {
                for (int j = b; j < b + size; j++) {
                    board[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            board[a][b] = '*';
            return;
        }

        int curSize = size / 3;
        int count = 0;

        for (int i = a; i < a + size; i += curSize) {
            for (int j = b; j < b + size; j += curSize) {
                count++;
                if(count == 5){
                    star(i, j, curSize, true);
                } else {
                    star(i, j, curSize, false);
                }
            }
        }
    }
}
