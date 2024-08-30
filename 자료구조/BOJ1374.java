package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1374 {
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static class Lecture implements Comparable<Lecture> {
        int no;
        int start;
        int end;

        Lecture(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

        //시작시간비교, 시작시간이 같다면 종료시간 비교( 정렬에 사용할 Comparable 클래스의 compareTo 메소드 오버라이드)
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures);// 시작 시간 순으로 정렬

        getPriorityQueue(lectures);

        System.out.println(pq.size());
    }

    private static void getPriorityQueue(Lecture[] lectures) {
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                pq.offer(lectures[i].end);
            } else {
                int endTime = pq.peek();
                if (lectures[i].start < endTime) {// 현재 우선순위큐에 있는 강의중 끝나는 시간이 가장 짧은 것과 시작시간을 비교
                    pq.offer(lectures[i].end);
                } else {
                    pq.poll();
                    pq.offer(lectures[i].end);
                }
            }
        }
    }
}
