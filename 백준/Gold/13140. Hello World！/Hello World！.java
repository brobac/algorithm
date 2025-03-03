import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    static boolean[] used = new boolean[10];

    // {d, e, h, l, o, r, w}
    static int[] selected = new int[7];

    static void solution(int cnt) {
        if (cnt == 7) {
            int hello = selected[2] * 10000 + selected[1] * 1000 + selected[3] * 100 + selected[3] * 10 + selected[4];
            int world = selected[6] * 10000 + selected[4] * 1000 + selected[5] * 100 + selected[3] * 10 + selected[0];


            if (hello + world == N) {
                System.out.println("  " + hello);
                System.out.println("+ " + world);
                System.out.println("-------");
                System.out.printf("%7d", N);

                System.exit(0);
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (used[i]) continue;
            if (cnt == 2 || cnt == 6) {
                if (i == 0) continue;
            }
            used[i] = true;
            selected[cnt] = i;
            solution(cnt + 1);
            used[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solution(0);
        System.out.println("No Answer");
    }
}