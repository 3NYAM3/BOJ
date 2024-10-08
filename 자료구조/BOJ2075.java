package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2075 {
    static int n;
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                priorityQueue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < n-1; i++) {
            priorityQueue.poll();
        }
        System.out.println(priorityQueue.peek());

    }
}
