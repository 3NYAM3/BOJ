import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
    static int row, col;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        table = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                table[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        br.close();

        int max = Math.min(row, col);

        while (max > 1) {

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i + max - 1 < row && j + max - 1 < col){
                        if(table[i][j]==table[i+max-1][j]&&table[i][j]==table[i][j+max-1]&&table[i][j]==table[i+max-1][j+max-1]){
                            System.out.println(max*max);
                            return;
                        }
                    }
                }
            }

            max--;
        }

        System.out.println(1);

    }
}
