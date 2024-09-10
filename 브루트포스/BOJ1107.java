package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
    static int n, m;
    static boolean[] error;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        error = new boolean[10];

        if(m!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int a = Integer.parseInt(st.nextToken());
                error[a] = true;
            }
        }


        int curChannel = 100;

        if (n == curChannel) {
            System.out.println(0);
            return;
        }

        count = Math.abs(n - curChannel);

        dfs(0, 0);
        System.out.println(count);
    }

    static void dfs(int num, int index) {
        for (int i = 0; i < 10; i++) {
            if (!error[i]) {
                int curNum = num * 10 + i;
                count = Math.min(count, Math.abs(n - curNum) + (curNum+"").length());
                if (index < 6) {
                    dfs(curNum, index + 1);
                }
            }
        }
    }
}
