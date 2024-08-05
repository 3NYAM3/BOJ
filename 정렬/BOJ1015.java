import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;;

public class BOJ1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] A = new int[num];
        int[] B = new int[num];

        String answer="";

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }

        Arrays.sort(B);

        for (int i = 0 ; i < num ; i++) {
            for (int j = 0 ; j < num ; j++) {
                if(A[i]==B[j]){
                    answer=answer+j+" ";
                    B[j] = 9999999;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}