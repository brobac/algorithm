import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, T;

    static int[][] board;


    static void printBoard() {
        System.out.println("----- print board -----");
        for (int i = 1; i <= N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M];
        int sum = 0;
        int count = N * M;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                sum += board[i][j];
            }
        }

        for (int t = 0; t < T; t++) {
            if (count == 0) break;

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // x의 배수인 원판
            for (int i = x; i <= N; i += x) {
                if (d == 0) {
                    // 시계방향
                    int[] temp = new int[M];
                    for (int j = 0; j < M; j++) {
                        int next = (j + k) % M;
                        temp[next] = board[i][j];
                    }
                    board[i] = temp;

                } else {
                    // 반시계방향
                    int[] temp = new int[M];
                    for (int j = 0; j < M; j++) {
                        int next = (j - k + M * k) % M;
                        temp[next] = board[i][j];
                    }
                    board[i] = temp;

                }
            }


//            System.out.println("----- after turn -----");
//            printBoard();

            // 인접확인

            boolean findAdj = false;

            boolean[][] visited = new boolean[N + 1][M];

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] || board[i][j] == 0) continue;

                    visited[i][j] = true;
                    ArrayList<int[]> adjList = new ArrayList<>();
                    adjList.add(new int[]{i, j});

                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});

                    int num = board[i][j];

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        int ci = cur[0];
                        int cj = cur[1];


                        int jRight = (cj + 1) % M;
                        if (!visited[ci][jRight] && board[ci][jRight] == num) {
                            visited[ci][jRight] = true;
                            adjList.add(new int[]{ci, jRight});
                            q.offer(new int[]{ci, jRight});
                        }

                        int jLeft = (cj - 1 + M) % M;
                        if (!visited[ci][jLeft] && board[ci][jLeft] == num) {
                            visited[ci][jLeft] = true;
                            adjList.add(new int[]{ci, jLeft});
                            q.offer(new int[]{ci, jLeft});
                        }

                        if (1 < ci && !visited[ci - 1][cj] && board[ci - 1][cj] == num) {
                            visited[ci - 1][cj] = true;
                            adjList.add(new int[]{ci - 1, cj});
                            q.offer(new int[]{ci - 1, cj});
                        }

                        if (ci < N && !visited[ci + 1][cj] && board[ci + 1][cj] == num) {
                            visited[ci + 1][cj] = true;
                            adjList.add(new int[]{ci + 1, cj});
                            q.offer(new int[]{ci + 1, cj});

                        }
                    }


                    if (2 <= adjList.size()) {

                        findAdj = true;
                        sum -= adjList.size() * num;
                        count -= adjList.size();
                        for (int[] p : adjList) {
                            board[p[0]][p[1]] = 0;
                        }
                    }
                }
            }


//            System.out.println("----- after finding adj -----");
//            printBoard();

            if (findAdj) continue;

            double avg = (double) sum / count;
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0) continue;

                    if (avg < board[i][j]) {
                        board[i][j]--;
                        sum--;
                    } else if (board[i][j] < avg) {
                        board[i][j]++;
                        sum++;

                    }
                }
            }


//            System.out.println("----- after avg -----");
//            printBoard();

        }

        System.out.println(sum);
    }
}