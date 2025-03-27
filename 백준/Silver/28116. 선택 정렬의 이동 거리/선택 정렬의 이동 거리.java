import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] idx = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            A[i] = v;
            idx[v] = i;
        }
        int[] move = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int d = idx[i + 1] - i;
            move[i + 1] += d;
            move[A[i]] += d;

            int minIdx = idx[i + 1];
            int curNum = A[i];

            idx[curNum] = minIdx;
            idx[i + 1] = i;


            A[i] = i + 1;
            A[minIdx] = curNum;

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(move[i]).append(" ");
        }

        System.out.println(sb);
    }
}