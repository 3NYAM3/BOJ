package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1474 {
    static int n, m, len = 0;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
            len += word[i].length();
        }

        int totalUnderscores = m - len;
        int baseUnderscore = totalUnderscores / (n - 1);
        int extraUnderscore = totalUnderscores % (n - 1);

        boolean isAdditionalInsertIndex[] = new boolean[n];


        for (int i = 1; i < n; i++) {
            if (extraUnderscore == 0) {
                break;
            }
            if ('a' <= word[i].charAt(0)) {
                isAdditionalInsertIndex[i] = true;
                extraUnderscore--;
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            if (extraUnderscore == 0) {
                break;
            }
            if (word[i].charAt(0) <= 'Z') {
                isAdditionalInsertIndex[i] = true;
                extraUnderscore--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < baseUnderscore; j++) {
                sb.append('_');
            }

            if (isAdditionalInsertIndex[i]) {
                sb.append('_');
            }
            sb.append(word[i]);
        }

        System.out.println(sb);
    }


}
