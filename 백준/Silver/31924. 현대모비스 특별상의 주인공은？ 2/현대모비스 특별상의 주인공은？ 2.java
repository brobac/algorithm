import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }

        int result = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 좌상
                if (4 <= r && 4 <= c
                        && map[r][c] == 'M'
                        && map[r - 1][c - 1] == 'O'
                        && map[r - 2][c - 2] == 'B'
                        && map[r - 3][c - 3] == 'I'
                        && map[r - 4][c - 4] == 'S'
                ) {
                    result++;
                }

                // 상

                if (4 <= r
                        && map[r][c] == 'M'
                        && map[r - 1][c] == 'O'
                        && map[r - 2][c] == 'B'
                        && map[r - 3][c] == 'I'
                        && map[r - 4][c] == 'S'
                ) {

                    result++;
                }

                // 우상
                if (4 <= r && c <= N - 5
                        && map[r][c] == 'M'
                        && map[r - 1][c + 1] == 'O'
                        && map[r - 2][c + 2] == 'B'
                        && map[r - 3][c + 3] == 'I'
                        && map[r - 4][c + 4] == 'S'
                ) {

                    result++;
                }

                //좌
                if (4 <= c
                        && map[r][c] == 'M'
                        && map[r][c - 1] == 'O'
                        && map[r][c - 2] == 'B'
                        && map[r][c - 3] == 'I'
                        && map[r][c - 4] == 'S'
                ) {

                    result++;
                }

                //우
                if (c <= N - 5
                        && map[r][c] == 'M'
                        && map[r][c + 1] == 'O'
                        && map[r][c + 2] == 'B'
                        && map[r][c + 3] == 'I'
                        && map[r][c + 4] == 'S'
                ) {

                    result++;
                }

                //좌하

                if (r <= N - 5 && 4 <= c
                        && map[r][c] == 'M'
                        && map[r + 1][c - 1] == 'O'
                        && map[r + 2][c - 2] == 'B'
                        && map[r + 3][c - 3] == 'I'
                        && map[r + 4][c - 4] == 'S'
                ) {

                    result++;
                }


                //하

                if (r <= N - 5
                        && map[r][c] == 'M'
                        && map[r + 1][c] == 'O'
                        && map[r + 2][c] == 'B'
                        && map[r + 3][c] == 'I'
                        && map[r + 4][c] == 'S'
                ) {

                    result++;
                }


                //우하

                if (r <= N - 5 && c <= N - 5
                        && map[r][c] == 'M'
                        && map[r + 1][c + 1] == 'O'
                        && map[r + 2][c + 2] == 'B'
                        && map[r + 3][c + 3] == 'I'
                        && map[r + 4][c + 4] == 'S'
                ) {

                    result++;
                }

            }
        }

        System.out.println(result);
    }
}