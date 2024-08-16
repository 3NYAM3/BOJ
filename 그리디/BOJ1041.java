package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1041 {
    static long N;
    static long[] dice = new long[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long one = Long.MAX_VALUE;
        long two = Long.MAX_VALUE;
        long three = 0;

        long max = Long.MIN_VALUE;

        for (long diceNum : dice) {
            one = Math.min(one, diceNum);
            max = Math.max(max, diceNum);
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i != j && i + j != 5) {
                    two = Math.min(two, dice[i] + dice[j]);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            three += Math.min(dice[i], dice[5 - i]);
        }

        one = one * ((N - 2) * (N - 2) + 4 * (N - 2) * (N - 1));
        two = two * (4 * (2 * N - 3));
        three = three * 4;

        long sum = 0;

        if (N == 1) {
            for (long diceNUm : dice) {
                sum += diceNUm;
            }
            System.out.println(sum - max);
        } else {
            System.out.println(one + two + three);
        }
    }
}
