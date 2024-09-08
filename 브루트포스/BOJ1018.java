import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    static int row, col;
    static String[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new String[row];

        for (int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;

        //8*8 시작 지점 구하기
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int curMin = getMin(i, j);

                if (curMin < min) {
                    min = curMin;
                }
            }
        }

        System.out.println(min);

    }

    static int getMin(int startRow, int StartCol) {
        String[] correctBoard = {"WBWBWBWB", "BWBWBWBW"};

        int whiteMin = 0;

        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = StartCol + j;
                if (board[row].charAt(col) != correctBoard[row % 2].charAt(j)) {
                    whiteMin++;
                }
            }
        }

        return Math.min(whiteMin, 64-whiteMin); // 맨 왼쪽 위 칸이 흰색인 경우와 검은색인 경우를 합치면 64개 이므로
                                                // 검은색의 최소값은 64 - (흰색의 최소값)
    }
}
