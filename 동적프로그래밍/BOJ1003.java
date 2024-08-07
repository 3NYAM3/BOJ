import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    static int testCaseNum;
    static int testCase[];
    static int[][] dp = new int[50][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCaseNum = Integer.parseInt(br.readLine());
        testCase = new int[testCaseNum];

        for (int i = 0; i < testCaseNum; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < testCaseNum; i++) {
            fibonacci(testCase[i]);
            System.out.println(dp[testCase[i]][0] + " " + dp[testCase[i]][1]);
        }


    }

    static void fibonacci(int n) {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }
}
