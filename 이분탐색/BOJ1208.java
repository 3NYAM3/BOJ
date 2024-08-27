package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1208 {
    static int n, s;
    static long count;
    static int[] arr;
    static ArrayList<Integer> left = new ArrayList<>();
    static ArrayList<Integer> right = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력받기
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sumList(0, 0, n / 2, left);
        sumList(0, n / 2, n, right);

        Collections.sort(left);
        Collections.sort(right);

        count = 0;

        sumLeftRight();


        if (s == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }

    }

    static void sumList(int sum, int start, int end, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        sumList(sum, start + 1, end, list);
        sumList(sum + arr[start], start + 1, end, list);
    }

    static void sumLeftRight() {
        int pl = 0;
        int pr = right.size() - 1;

        while (true) {
            if (pl == left.size() || pr < 0) {
                break;
            }

            int sum = left.get(pl) + right.get(pr);

            if (sum == s) {
                int l = left.get(pl);
                long lCount = 0;

                while (pl < left.size() && left.get(pl) == l) {
                    pl++;
                    lCount++;
                }

                int r = right.get(pr);
                long rCount = 0;
                while (pr >= 0 && right.get(pr) == r) {
                    pr--;
                    rCount++;
                }

                count += lCount * rCount;
            }

            if (sum < s) {
                pl++;
            }

            if (sum > s) {
                pr--;
            }
        }
    }
}
