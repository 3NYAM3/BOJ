package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1105 {
    static String l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = st.nextToken();
        r = st.nextToken();

        int count = 0;

        if (l.length() == r.length()) {
            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) != r.charAt(i)) {
                    break;
                } else if (l.charAt(i) == '8') {
                    count++;
                }

            }
        }

        System.out.println(count);

    }
}
