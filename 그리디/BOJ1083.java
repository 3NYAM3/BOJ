package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1083 {
    static int N;
    static int[] arr;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        if (N * (1 + N) / 2 < S) {
            Arrays.sort(arr);
            sb = new StringBuilder();
            for (int i = N-1; i >= 0; i--) {
                sb.append(arr[i]).append(' ');
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N && S > 0; i++) {
            int max = arr[i];
            int maxIdx = -1;

            for (int j = i + 1; j < N && j <= i + S; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIdx = j;
                }
            }
            if (maxIdx != -1) {
                S -= maxIdx - i;


                for (int j = maxIdx; j >= i + 1; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }
}
