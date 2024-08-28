package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1464 {
    static String s;
    static StringBuilder word = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        word.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c > word.charAt(word.length() - 1)) {
                word.insert(0, c);
            } else {
                word.append(c);
            }
        }

        System.out.println(word.reverse().toString());
    }


}
