import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int[][] multiple(int[][] a, int[][] b) {
        int[][] result = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int i = 0; i < N; i++) {
                    result[r][c] += a[r][0 + i] * b[0 + i][c];
                }
                result[r][c] %= 1000;
            }
        }
        return result;
    }

    static int[][] power(int[][] matrix, long n) {
        if (n == 1) {
            int[][] result = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    result[r][c] = matrix[r][c] % 1000;
                }
            }
            return result;
        }

        int[][] half = power(matrix, n / 2);

        if (n % 2 == 0) {
            return multiple(half, half);
        }

        return multiple(matrix, multiple(half, half));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = power(matrix, B);

        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(result[r][c]).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}