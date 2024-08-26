import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int testCaseNum; //테스트 케이스 개수
    static int row, col, cabbageNum; // 밭의 가로, 세로, 배추 개수
    static int[][] cabbageRoc; // 배추의 위치
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 개수
        testCaseNum = Integer.parseInt(br.readLine());

        //밭 크기와 배추 개수
        for(int i = 0; i < testCaseNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            cabbageNum = Integer.parseInt(st.nextToken());

            cabbageRoc = new int[row][col];
            visit = new boolean[row][col];

            for(int j = 0; j < cabbageNum; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbageRoc[x][y] = 1;
            }

            int count = 0;

            for(int x = 0; x < row; x++){
                for(int y = 0; y < col; y++){
                    if(cabbageRoc[x][y] == 1 && !visit[x][y]){
                        //System.out.println("x ="+x+", y = "+y);
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }

    }


    //깊이 우선 탐색
    static void dfs(int x, int y){
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){//상 -> 하 -> 좌 -> 우 순서대로 깊이우선 탐색
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col){ //밭 크기 안의 좌표
                if(cabbageRoc[nextX][nextY] == 1 && !visit[nextX][nextY]){
                    dfs(nextX, nextY); // 재귀 함수
                }
            }
        }
    }


    //너비 우선 탐색
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            x = q.peek()[0];
            y = q.peek()[1];

            visit[x][y] = true;
            q.poll();
            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col){
                    if(cabbageRoc[nextX][nextY] == 1&& !visit[nextX][nextY]){
                        q.add(new int[]{nextX, nextY});
                        visit[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
