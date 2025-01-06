import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;

    static int[] p;

    static int find(int n) {
        if (n == p[n]) {
            return n;
        }
        p[n] = find(p[n]);

        return p[n];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        p[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        int connected = 0;

        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < K; i++) {
            int v = Integer.parseInt(st.nextToken());
            union(prev, v);
            prev = v;
            connected++;
        }


        int[][] edgeList = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList[i][0] = Integer.parseInt(st.nextToken());
            edgeList[i][1] = Integer.parseInt(st.nextToken());
            edgeList[i][2] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));


        int result = 0;
        for (int[] edge : edgeList) {
            if (connected == N - 1) {
                break;
            }
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (find(u) == find(v)) {
                continue;
            }

            union(u, v);
            connected++;
            result += w;

        }
        System.out.println(result);

    }
}