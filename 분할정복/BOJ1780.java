package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    static int n;
    static int[][] paper;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        paper = new int[n][n];
        count = new int[3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
        br.close();
    }

    static void solve(int a, int b, int size) {
        if (checkNum(a, b, size)) {
            if (paper[a][b] == -1) count[0]++;
            if (paper[a][b] == 0) count[1]++;
            if (paper[a][b] == 1) count[2]++;
            return;
        }

        int curSize = size / 3;

        for (int i = a; i < size + a; i += curSize) {
            for (int j = b; j < size + b; j += curSize) {
                solve(i, j, curSize);
            }
        }

    }

    static boolean checkNum(int a, int b, int size) {
        int num = paper[a][b];

        for (int i = a; i < size + a; i++) {
            for (int j = b; j < size + b; j++) {
                if (num != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
