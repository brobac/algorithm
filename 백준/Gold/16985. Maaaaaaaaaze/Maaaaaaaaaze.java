import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][][] board = new int[4][5][5][5];
    static int result = Integer.MAX_VALUE;

    static int[] order = new int[5];
    static boolean[] visited = new boolean[5];

    static int[] df = {-1, 1, 0, 0, 0, 0};
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 0, -1, 1};

    static void rotatedBoard() {
        for (int i = 1; i < 4; i++) {
            for (int b = 0; b < 5; b++) {
                for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        board[i][b][c][4 - r] = board[i - 1][b][r][c];
                    }
                }
            }

        }

    }

    static boolean outOfMap(int f, int r, int c) {
        return f < 0 || r < 0 || c < 0 || 5 <= f || 5 <= r || 5 <= c;
    }


    static void solution(int cnt) {
        if (cnt == 5) {
            for (int f1 = 0; f1 < 4; f1++) {
                for (int f2 = 0; f2 < 4; f2++) {
                    for (int f3 = 0; f3 < 4; f3++) {
                        for (int f4 = 0; f4 < 4; f4++) {
                            for (int f5 = 0; f5 < 4; f5++) {
                                int[][][] maze = new int[5][5][5];
                                maze[0] = board[f1][order[0]];
                                maze[1] = board[f2][order[1]];
                                maze[2] = board[f3][order[2]];
                                maze[3] = board[f4][order[3]];
                                maze[4] = board[f5][order[4]];

                                if (maze[0][0][0] != 1 || maze[4][4][4] != 1) continue;

                                boolean[][][] used = new boolean[5][5][5];

                                Queue<int[]> q = new ArrayDeque<>();
                                q.offer(new int[]{0, 0, 0, 0});
                                used[0][0][0] = true;
                                while (!q.isEmpty()) {
                                    int[] cur = q.poll();
                                    int f = cur[0];
                                    int r = cur[1];
                                    int c = cur[2];
                                    int count = cur[3];

                                    if (f == 4 && r == 4 && c == 4) {
                                        result = Math.min(result, count);
                                        break;
                                    }

                                    for (int d = 0; d < 6; d++) {
                                        int nf = f + df[d];
                                        int nr = r + dr[d];
                                        int nc = c + dc[d];

                                        if (outOfMap(nf, nr, nc) || used[nf][nr][nc] || maze[nf][nr][nc] == 0) continue;
                                        used[nf][nr][nc] = true;
                                        q.offer(new int[]{nf, nr, nc, count + 1});
                                    }


                                }

                            }
                        }
                    }
                }
            }
            return;
        }


        for (int i = 0; i < 5; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            order[cnt] = i;
            solution(cnt + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int b = 0; b < 5; b++) {
            for (int r = 0; r < 5; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 5; c++) {
                    board[0][b][r][c] = Integer.parseInt(st.nextToken());
                }
            }
        }

        rotatedBoard();

        solution(0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);


    }
}