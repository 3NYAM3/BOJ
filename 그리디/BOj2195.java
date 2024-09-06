package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOj2195 {
    static String s, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        p = br.readLine();

        int count = 0;

        int pIndex = 0;

        for (int i = 0; i < p.length(); i++) {
            if (s.contains(p.substring(pIndex, i + 1))) {
                continue;
            }
            count++;
            pIndex = i;
        }
        System.out.println(count + 1);
    }
}
