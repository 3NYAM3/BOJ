package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1141 {
    static int n;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        word = new String[n];

        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }
        // 길이가 긴 순으로 정렬
        Arrays.sort(word, (o1, o2) -> o2.length() - o1.length());


        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isPrefix = false;
            for (int j = 0; j < i; j++) {
                if(word[j].startsWith(word[i])){
                    isPrefix = true;
                    break;
                }
            }
            if(!isPrefix){
                count++;
            }
        }

        System.out.println(count);
    }
}
