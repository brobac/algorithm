import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] items;
    static int result = Integer.MAX_VALUE;

    static int[] minimums = new int[4];
    static boolean[] used;
    static ArrayList<Integer> usedList = new ArrayList<>();


    static void solution(int[] sums, int cnt) {
        if (result <= sums[4]) return;

        boolean pass = true;

        for (int i = 0; i < 4; i++) {
            if (sums[i] < minimums[i]) {
                pass = false;
                break;
            }
        }

        if (pass && sums[4] < result) {
            result = sums[4];
            usedList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (used[i]) {
                    usedList.add(i + 1);
                }
            }
            return;
        }

        if (cnt == N) return;


        int[] next = new int[5];
        for (int j = 0; j < 5; j++) {
            next[j] = sums[j] + items[cnt][j];
        }
        used[cnt] = true;
        solution(next, cnt + 1);
        used[cnt] = false;
        solution(Arrays.copyOf(sums, 5), cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minimums[i] = Integer.parseInt(st.nextToken());
        }
        items = new int[N][5];
        used = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                items[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(new int[]{0, 0, 0, 0, 0}, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(result).append("\n");
            for (int n : usedList) {
                sb.append(n).append(" ");
            }
            System.out.println(sb);

        }
    }
}