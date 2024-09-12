package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        //n=i 자리의 j부터 시작하는 오르막수의 개수는 i-1자리에서 j부터 9로 시작하는 오르막수 개수의 합
        //예 n=1일때는 오르막수는 0,1,2,3,4,5,6,7,8,9 -> j부터 시작하는수 각각 1개씩 10개 이므로 n=2 두자리 수 일때는 0으로 시작하는건 10개 1로 시작하는건 9개 ..
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
            result %= 10007;
        }

        System.out.println(result);
    }
}
