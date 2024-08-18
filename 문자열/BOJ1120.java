package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1120 {
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        str1 = st.nextToken();
        str2 = st.nextToken();

        int result = 50;

        for (int i = 0; i <= (str2.length() - str1.length()); i++) {
            int count = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(i + j)) {
                    count++;
                }
            }
            result = Math.min(result, count);
        }
        System.out.println(result);
    }
}
