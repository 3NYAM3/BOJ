package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
    static int n;
    static int[][] arr;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        divide(0, 0, n);

        System.out.println(ans);
    }

    static void divide(int a, int b, int size) {
        if (canCompress(a, b, size)) {
            ans.append(arr[a][b]);
            return;
        }

        int curSize = size / 2;

        ans.append("(");

        divide(a, b, curSize);                             //1사분면
        divide(a, b + curSize, curSize);                //2사분면
        divide(a + curSize, b, curSize);                //3사분면
        divide(a + curSize, b + curSize, curSize);   //4사분면

        ans.append(")");
    }

    static boolean canCompress(int a, int b, int size) {
        int temp = arr[a][b];

        for (int i = a; i < a + size; i++) {
            for (int j = b; j < b + size; j++) {
                if (arr[i][j] != temp) {
                    return false;
                }
            }
        }
        return true;
    }
}
