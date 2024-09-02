package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
    static int n, r, c;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        z(0, 0, size);
    }

    static void z(int a, int b, int size) {
        if (size == 1) {
            System.out.println(ans);
            return;
        }

        int dividedSize = size / 2;

        //1사분면
        if (r < a + dividedSize && c < b + dividedSize) {
            z(a, b, dividedSize);
        }

        //2사분면
        if (r < a + dividedSize && c >= b + dividedSize) {
            ans += (size*size)/4;
            z(a, b + dividedSize, dividedSize);
        }

        //3사분면
        if (r >= a + dividedSize && c < b + dividedSize) {
            ans += ((size*size)/4)*2;
            z(a + dividedSize, b, dividedSize);
        }

        //4사분면
        if (r >= a + dividedSize && c >= b + dividedSize) {
            ans += ((size*size)/4)*3;
            z(a + dividedSize, b + dividedSize, dividedSize);
        }
    }
}
