package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1443 {
    static long d, p;
    static long maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        dfs(1, 0, 9);

        if(maxValue==0){
            System.out.println(-1);
        } else {
            System.out.println(maxValue);
        }
    }

    static void dfs(long curValue, int depth, int start) {
        if (depth == p) {
            maxValue = Math.max(maxValue, curValue);
            return;
        }

        for (int i = start; i >= 2; i--) {
            long nextValue = curValue * i;
            if ((nextValue + "").length() <= d) {
                dfs(nextValue, depth + 1, i);
            }

        }
    }
}
