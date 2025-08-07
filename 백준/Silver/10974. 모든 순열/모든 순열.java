import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] selected;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    static void permutation(int cnt) {
        if (cnt == N) {

            for (int i = 0; i < N; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) continue;
            used[i] = true;
            selected[cnt] = i;
            permutation(cnt + 1);
            used[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        selected = new int[N];
        used = new boolean[N + 1];


        permutation(0);

        System.out.println(sb);
    }
}