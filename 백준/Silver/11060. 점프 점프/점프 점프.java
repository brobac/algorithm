import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] jump = new int[N];
        Arrays.fill(jump, -1);
        jump[0] = 0;

        for (int i = 0; i < N - 1; i++) {
            if (jump[i] == -1) continue;

            for (int j = i + 1; j <= i + A[i] && j < N; j++) {
                if (jump[j] == -1 || jump[i] + 1 < jump[j]) {
                    jump[j] = jump[i] + 1;
                }
            }
        }

        System.out.println(jump[N - 1]);
    }
}