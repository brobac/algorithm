import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] next;
    static int maxCount, result;
    static boolean[] visited;

    static void solution(int start, int cur, int count) {
        visited[cur] = true;
        if (maxCount < count + 1) {
            maxCount = count + 1;
            result = start;
        }

        if (!visited[next[cur]]) {
            solution(start, next[cur], count + 1);
        }
        visited[cur] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        next = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            next[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            solution(i, i, 0);
        }

        System.out.println(result);

    }
}