import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] D = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(D[i], Integer.MAX_VALUE);
            D[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            D[A][B] = T;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (D[i][k] == Integer.MAX_VALUE || D[k][j] == Integer.MAX_VALUE) continue;
                    int sum = D[i][k] + D[k][j];
                    if (sum < D[i][j]) {
                        D[i][j] = sum;
                    }
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        List<Integer> cityList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            cityList.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> resultList = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        find:
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int c : cityList) {
                if (D[i][c] == Integer.MAX_VALUE || D[c][i] == Integer.MAX_VALUE) continue find;
                int sum = D[i][c] + D[c][i];
                max = Math.max(max, sum);
            }
            if (max < minDistance) {
                resultList = new ArrayList<>();
                resultList.add(i);
                minDistance = max;
            } else if (max == minDistance) {
                resultList.add(i);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int v : resultList) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }
}