package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1599 {
    static int n;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            words[i] = words[i].replace('k', 'c');
            words[i] = words[i].replace("ng", "n}");
        }

        Arrays.sort(words);

        for (int i = 0; i < n; i++) {
            words[i] = words[i].replace("n}", "ng");
            words[i] = words[i].replace('c', 'k');
        }

        for (int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }

    }
}
