import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Set<Integer>[] childSet;
    static int result = 0;

    static void dfs(int cur) {
        if (childSet[cur].isEmpty()) {
            result++;
            return;
        }

        for (int v : childSet[cur]) {
            dfs(v);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int root = 0;
        childSet = new Set[N];
        for (int i = 0; i < N; i++) {
            childSet[i] = new HashSet<>();
        }
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            if (p[i] == -1) {
                root = i;
                continue;
            }

            childSet[p[i]].add(i);
        }

        int R = Integer.parseInt(br.readLine());
        if (p[R] == -1) {
            System.out.println(0);
            return;
        }
        childSet[p[R]].remove(R);
        dfs(root);

        System.out.println(result);

    }
}