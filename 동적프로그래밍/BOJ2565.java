package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565 {
    static int n;
    static int[][] wire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        wire = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        //A 전깃줄을 기준으로 오름차순 정렬
        Arrays.sort(wire, Comparator.comparingInt(a -> a[0]));

        //최장증가부분수열 메모이제이션을 위한 배열선언, length는 현재 최장증가부분수열의 길이
        int[] dp = new int[n];
        int length = 0;

        //이분탐색을 이용한 최장증가부분수열 찾기
        for(int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(dp, 0, length , wire[i][1]);
            if(pos < 0){
                pos = -pos - 1;
            }
            dp[pos] = wire[i][1];
            if(pos == length){
                length++;
            }
        }

        System.out.println(n-length);
    }
}
