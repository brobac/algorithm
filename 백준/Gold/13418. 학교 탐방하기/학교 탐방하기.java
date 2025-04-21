import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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
        if (a == b) return;

        p[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            p[i] = i;
        }

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.add(new int[]{A, B, C});

        }

        int min = 0;
        int max = 0;

        list.sort(Comparator.comparingInt(v -> v[2]));

        int count = 0;
        int up = 0;
        for (int i = 0; i <= M; i++) {
            int[] cur = list.get(i);
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            if (find(a) == find(b)) continue;
            count++;
            if (c == 0) up++;
            union(a, b);


            if (count == N) break;
        }

        max = up * up;

        count = 0;
        up = 0;
        for (int i = 0; i <= N; i++) {
            p[i] = i;
        }
        for (int i = M; i >= 0; i--) {
            int[] cur = list.get(i);
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            if (find(a) == find(b)) continue;
            count++;
            if (c == 0) up++;
            union(a, b);

            if (count == N) break;
        }

        min = up * up;

        System.out.println(max - min);

    }
}