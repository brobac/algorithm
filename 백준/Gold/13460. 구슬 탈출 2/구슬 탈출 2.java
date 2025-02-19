import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N : 세로, M : 가로
 * 최대 10번 굴릴 수 있음 4^10( 약 100만번)
 * BFS로 구슬 굴리기
 * 왼쪽으로 굴릴 때 : 행이 같다면 열이 작은 구슬 먼저 굴리기
 * 오른쪽으로 굴릴 때 : 행이 같다면 열이 큰 구슬 먼저 굴리기
 * 위로 굴릴 때 : 열이 같다면 행이 작은 구슬 먼저 굴리기
 * 아래로 굴릴 때 : 열이 같다면 행이 큰 구슬 먼저 굴리기
 * 굴리기가 끝났을 때 파란 구슬이 구멍에 들어가면 더 이상 굴려볼 필요없다.
 * 굴리기가 끝났을 때 빨간 구슬만 들어가고 파란 구슬이 안들어 갔다면 그 때까지 굴린 횟수 출력 후 종료
 * 굴리기가 끝났지만 아무 구슬도 안들어갔다면 그 위치에서 다시 4방향 굴리기
 */
public class Main {
    static int N, M;
    static int redRow, redCol, blueRow, blueCol;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static char[][] copyMap(char[][] map) {
        char[][] result = new char[N][M];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                result[row][col] = map[row][col];

            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int row = 0; row < N; row++) {
            char[] input = br.readLine().toCharArray();
            for (int col = 0; col < M; col++) {
                map[row][col] = input[col];
                if (map[row][col] == 'R') {
                    redRow = row;
                    redCol = col;
                } else if (map[row][col] == 'B') {
                    blueRow = row;
                    blueCol = col;
                }
            }
        }

        Snapshot snapshot = new Snapshot(redRow, redCol, blueRow, blueCol, map, 0);
        Queue<Snapshot> q = new ArrayDeque<>();
        q.add(snapshot);
        while (!q.isEmpty()) {
            Snapshot cur = q.poll();


            for (int d = 0; d < 4; d++) {
                Snapshot s = cur.copy();
                s.move(d);
                if (s.blueGoal) continue;

                if (s.redGoal) {
                    System.out.println(s.moveCount + 1);
                    return;
                }
                Snapshot next = s.copy();
                next.moveCount++;

                if (next.moveCount < 10) {
                    q.add(next);
                }
            }
        }

        System.out.println(-1);
    }

    static class Snapshot {
        int redRow, redCol, blueRow, blueCol;
        char[][] map;
        int moveCount;
        boolean redGoal, blueGoal;

        public Snapshot(int redRow, int redCol, int blueRow, int blueCol, char[][] map, int moveCount) {
            this.redRow = redRow;
            this.redCol = redCol;
            this.blueRow = blueRow;
            this.blueCol = blueCol;
            this.map = map;
            this.moveCount = moveCount;
            redGoal = false;
            blueGoal = false;
        }

        public Snapshot copy() {
            return new Snapshot(redRow, redCol, blueRow, blueCol, copyMap(map), moveCount);
        }

        public char getFirstColor(int d) {
            switch (d) {
                case 0: // up
                    return redRow < blueRow ? 'R' : 'B';
                case 1: // down
                    return redRow > blueRow ? 'R' : 'B';
                case 2: // left
                    return redCol < blueCol ? 'R' : 'B';
                case 3: // right
                    return redCol > blueCol ? 'R' : 'B';
                default:
                    return 'R';
            }
        }

        public void move(int d) {
            switch (d) {
                case 0:
                    moveUp();
                    break;
                case 1:
                    moveDown();
                    break;
                case 2:
                    moveLeft();
                    break;
                case 3:
                    moveRight();
                    break;
            }
        }

        public void moveUp() {
            if (getFirstColor(0) == 'R') {
                redUp();
                blueUp();
            } else {
                blueUp();
                redUp();
            }
        }

        private void redUp() {
            map[redRow][redCol] = '.';

            while (map[redRow - 1][redCol] == '.' || map[redRow - 1][redCol] == 'O') {
                if (map[redRow - 1][redCol] == '.') {
                    redRow--;
                } else {
                    redRow--;
                    redGoal = true;
                    return;
                }
            }

            map[redRow][redCol] = 'R';
        }

        private void blueUp() {
            map[blueRow][blueCol] = '.';

            while (map[blueRow - 1][blueCol] == '.' || map[blueRow - 1][blueCol] == 'O') {
                if (map[blueRow - 1][blueCol] == '.') {
                    blueRow--;
                } else {
                    blueRow--;
                    blueGoal = true;
                    return;
                }
            }

            map[blueRow][blueCol] = 'B';
        }

        public void moveDown() {
            if (getFirstColor(1) == 'R') {

                redDown();
                blueDown();
            } else {
                blueDown();
                redDown();
            }
        }

        private void redDown() {
            map[redRow][redCol] = '.';

            while (map[redRow + 1][redCol] == '.' || map[redRow + 1][redCol] == 'O') {
                if (map[redRow + 1][redCol] == '.') {
                    redRow++;
                } else {
                    redRow++;
                    redGoal = true;
                    return;
                }
            }

            map[redRow][redCol] = 'R';
        }

        private void blueDown() {
            map[blueRow][blueCol] = '.';

            while (map[blueRow + 1][blueCol] == '.' || map[blueRow + 1][blueCol] == 'O') {
                if (map[blueRow + 1][blueCol] == '.') {
                    blueRow++;
                } else {
                    blueRow++;
                    blueGoal = true;
                    return;
                }
            }

            map[blueRow][blueCol] = 'B';
        }

        public void moveLeft() {
            if (getFirstColor(2) == 'R') {
                redLeft();
                blueLeft();
            } else {
                blueLeft();
                redLeft();
            }

        }

        private void redLeft() {
            map[redRow][redCol] = '.';

            while (map[redRow][redCol - 1] == '.' || map[redRow][redCol - 1] == 'O') {
                if (map[redRow][redCol - 1] == '.') {
                    redCol--;
                } else {
                    redCol--;
                    redGoal = true;
                    return;
                }
            }

            map[redRow][redCol] = 'R';
        }

        private void blueLeft() {
            map[blueRow][blueCol] = '.';

            while (map[blueRow][blueCol - 1] == '.' || map[blueRow][blueCol - 1] == 'O') {
                if (map[blueRow][blueCol - 1] == '.') {
                    blueCol--;
                } else {
                    blueCol--;
                    blueGoal = true;
                    return;
                }
            }

            map[blueRow][blueCol] = 'B';
        }

        public void moveRight() {

            if (getFirstColor(3) == 'R') {
                redRight();
                blueRight();
            } else {
                blueRight();
                redRight();
            }
        }

        private void redRight() {
            map[redRow][redCol] = '.';

            while (map[redRow][redCol + 1] == '.' || map[redRow][redCol + 1] == 'O') {
                if (map[redRow][redCol + 1] == '.') {
                    redCol++;
                } else {
                    redCol++;
                    redGoal = true;
                    return;
                }
            }

            map[redRow][redCol] = 'R';
        }

        private void blueRight() {
            map[blueRow][blueCol] = '.';

            while (map[blueRow][blueCol + 1] == '.' || map[blueRow][blueCol + 1] == 'O') {
                if (map[blueRow][blueCol + 1] == '.') {
                    blueCol++;
                } else {
                    blueCol++;
                    blueGoal = true;
                    return;
                }
            }

            map[blueRow][blueCol] = 'B';

        }
    }
}