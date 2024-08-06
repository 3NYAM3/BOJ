import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BOJ1021 {
    static LinkedList<Integer> queue = new LinkedList<>();
    static int[] getNumArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //큐 인덱스 수, 뽑아낼 원소 수 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int qNum = Integer.parseInt(st.nextToken());
        int getNum = Integer.parseInt(st.nextToken());

        //큐 전체 초기화
        for (int i = 1; i <= qNum; i++) {
            queue.offer(i);
        }

        //뽑아낼 원소 인덱스 입력 받기
        getNumArray = new int[getNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < getNum; i++) {
            getNumArray[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int num : getNumArray) {
            if (queue.peek() == num) {
                queue.poll();
            } else {
                if (queue.indexOf(num) < (double) queue.size() / 2) {// 중간보다 앞에 있을 때
                    while (queue.peek() != num) {
                        queue.offerLast(queue.pollFirst());
                        count++;
                    }
                    queue.poll();
                } else { //중간에 있거나 중간보다 뒤에 있을 때
                    while (queue.peek() != num) {
                        queue.offerFirst(queue.pollLast());
                        count++;
                    }
                    queue.poll();
                }
            }
        }
        System.out.println(count);
    }
}
