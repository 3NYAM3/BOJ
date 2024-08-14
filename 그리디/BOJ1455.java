import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1455 {
    static int row, col;
    static int[][] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        coin = new int[row][col];
        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                coin[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        int count = 0;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (coin[i][j] == 1) {
                    for (int k = i; k >= 0; k--) {
                        for (int l = j; l >= 0; l--) {
                            coin[k][l] = coin[k][l] == 1 ? 0 : 1;
                        }
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
