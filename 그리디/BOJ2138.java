package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2138 {
    static int n;
    static int[] before, after;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        before = new int[n];
        after = new int[n];

        String s1 = br.readLine();
        String s2 = br.readLine();
        for (int i = 0; i < n; i++) {
            before[i] = Integer.parseInt(s1.charAt(i) + "");
            after[i] = Integer.parseInt(s2.charAt(i) + "");
        }

        int press = solution(false);
        int notPress = solution(true);

        if (press == -1 && notPress == -1) {
            System.out.println(-1);
        } else if (press == -1) {
            System.out.println(notPress);
        } else if (notPress == -1) {
            System.out.println(press);
        } else {
            System.out.println(Math.min(press, notPress));
        }
    }

    static int solution(boolean press) {
        int[] bulbs = before.clone();
        int count = 0;

        if (press) {
            press(bulbs, 0);
            count++;
        }

        for (int i = 1; i < n; i++) {
            if (bulbs[i - 1] != after[i - 1]) {
                press(bulbs, i);
                count++;
            }
        }

        if (bulbs[n - 1] != after[n - 1]) {
            return -1;
        }
        return count;
    }

    static void press(int[] bulbs, int index) {
        bulbs[index] = 1 - bulbs[index];
        if (index - 1 >= 0) {
            bulbs[index - 1] = 1 - bulbs[index - 1];
        }
        if (index + 1 < n) {
            bulbs[index + 1] = 1 - bulbs[index + 1];
        }
    }
}
