package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1377 {
    static int n;
    static Num[] arr;

    static class Num implements Comparable<Num> {
        int value;
        int index;

        Num(int value, int index) {
            this.value = value;
            this.index = index;
        }

        //값을 정렬
        @Override
        public int compareTo(Num o) {
            return this.value - o.value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Num[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Num(Integer.parseInt(br.readLine()), i);
        }
        br.close();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, i - arr[i].index);
        }
        System.out.println(-1 * min + 1);

    }
}
