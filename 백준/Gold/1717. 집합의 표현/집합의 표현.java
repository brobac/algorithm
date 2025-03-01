import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] p;

    static int find(int n) {
        if (p[n] == n) return n;

        p[n] = find(p[n]);

        return p[n];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        p[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES\n" : "NO\n");
            }
        }

        System.out.println(sb);
    }
}