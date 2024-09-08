import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1025 {
    static int row, col;
    static int[][] table;
    static int output=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        table = new int[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                table[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = -row; k < row; k++) {//row의 공차
                    for (int l = -col; l < col; l++) {//col의 공차
                        if (k == 0 && l == 0) {
                            continue;
                        }

                        int num = 0;
                        int newRow = i;
                        int newCol = j;

                        while (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                            num = num *10+ table[newRow][newCol];

                            if(isPerfectSquare(num)){
                                output= Math.max(output, num);
                            }

                            newRow +=k;
                            newCol +=l;
                        }
                    }
                }
            }
        }
        System.out.println(output);
    }

    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
