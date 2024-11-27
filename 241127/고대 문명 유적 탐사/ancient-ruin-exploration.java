
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] map;
    static int[] tiles;
    static int m;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int[][] copy(int[][] map) {
        int[][] result = new int[5][5];
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                result[r][c] = map[r][c];
            }
        }
        return result;
    }


    static int[][] turnedMap(int[][] arr, int r, int c) {
        int[][] temp = copy(arr);

//        System.out.println("돌기전");
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Arrays.toString(temp[i]));
//        }
//
//        System.out.println("arr------");
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//
//        System.out.println(temp[r - 1][c - 1] + " =>" + arr[r + 1][c - 1]);
//        System.out.println(temp[r - 1][c] + " =>" + arr[r][c - 1]);
//        System.out.println(temp[r - 1][c + 1] + " =>" + arr[r - 1][c - 1]);
//        System.out.println(temp[r][c - 1] + " =>" + arr[r + 1][c]);
//        System.out.println(temp[r][c + 1] + " =>" + arr[r - 1][c]);
//        System.out.println(temp[r + 1][c - 1] + " =>" + arr[r + 1][c + 1]);
//        System.out.println(temp[r + 1][c] + " =>" + arr[r][c + 1]);
//        System.out.println(temp[r + 1][c + 1] + " =>" + arr[r - 1][c + 1]);
        temp[r - 1][c - 1] = arr[r + 1][c - 1];
        temp[r - 1][c] = arr[r][c - 1];
        temp[r - 1][c + 1] = arr[r - 1][c - 1];
        temp[r][c - 1] = arr[r + 1][c];
        temp[r][c + 1] = arr[r - 1][c];
        temp[r + 1][c - 1] = arr[r + 1][c + 1];
        temp[r + 1][c] = arr[r][c + 1];
        temp[r + 1][c + 1] = arr[r - 1][c + 1];

//        System.out.println("돌기후");
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Arrays.toString(temp[i]));
//        }

        return temp;
    }

    static int getScore(int[][] map) {
        int result = 0;
        boolean[][] visited = new boolean[5][5];
        boolean[][] empty = new boolean[5][5];

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (visited[r][c]) continue;
                visited[r][c] = true;
                Queue<int[]> q = new ArrayDeque<>();
                ArrayList<int[]> list = new ArrayList<>();
                q.offer(new int[]{r, c});
                int count = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];
                    int num = map[cr][cc];

                    count++;
                    list.add(new int[]{cr, cc});

                    for (int d = 0; d < 4; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];
                        if (nr < 0 || nc < 0 || 5 <= nr || 5 <= nc || visited[nr][nc] || map[nr][nc] != num) continue;
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
                if (3 <= count) {
                    result += count;
                    for (int[] pos : list) {
                        empty[pos[0]][pos[1]] = true;
                    }
                }
            }
        }

      


        for (int c = 0; c < 5; c++) {
            for (int r = 4; 0 <= r; r--) {
                if (empty[r][c]) {
                    map[r][c] = tiles[m++];
                }
            }
        }
      

        return result;
    }

    static int getFirstScore(int[][] map) {
        int result = 0;
        boolean[][] visited = new boolean[5][5];

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (visited[r][c]) continue;
                visited[r][c] = true;
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{r, c});
                int count = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];
                    int num = map[cr][cc];

                    count++;

                    for (int d = 0; d < 4; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];
                        if (nr < 0 || nc < 0 || 5 <= nr || 5 <= nc || visited[nr][nc] || map[nr][nc] != num) continue;
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
                if (3 <= count) {
                    result += count;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[5][5];
        tiles = new int[M];
        m = 0;

        for (int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            tiles[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < K; k++) {
            int maxFirstScore = 0;
            int centerR = -1;
            int centerC = -1;
            int turnCount = 0;

            for (int c = 1; c <= 3; c++) {
                for (int r = 1; r <= 3; r++) {
                    int[][] arr = copy(map);
                    for (int turn = 1; turn <= 3; turn++) {

                        //회전
                        int[][] temp = turnedMap(arr, r, c);

                        int score = getFirstScore(temp);
                        if (maxFirstScore < score) {
                            maxFirstScore = score;
                            centerR = r;
                            centerC = c;
                            turnCount = turn;
                        } else if (maxFirstScore == score && turn < turnCount) {
                            centerR = r;
                            centerC = c;
                            turnCount = turn;
                        }
                        //다음 각도 회전을 위해
                        arr = temp;
                    }
                }
            }
            // 탐사 진행 종료


            // 유물 획득 시작


            for (int i = 0; i < turnCount; i++) {
                map = turnedMap(map, centerR, centerC);
            }


            int sum = 0;
            int score = 0;
            do {
                score = getScore(map);
                sum += score;

            } while (0 < score);

            if (sum == 0) {
                break;
            }
            sb.append(sum).append(" ");

        }

        System.out.println(sb);
    }

}
