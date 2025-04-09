import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] b = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            b[i][0] = Integer.parseInt(st.nextToken());
            b[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(b, (i, j) -> {
            if (i[0] == j[0]) return i[1] - j[1];
            return i[0] - j[0];
        });

        ArrayList<int[]> list = new ArrayList<>();
        list.add(b[0]);
        for (int i = 1; i < N; i++) {
            int[] top = list.get(list.size() - 1);
            if (top[0] <= b[i][0] && b[i][0] <= top[1]) {
                top[1] = Math.max(top[1], b[i][1]);
            } else {
                list.add(b[i]);
            }
        }


        int result = list.get(0)[1];

        boolean[] visited = new boolean[list.size()];
        visited[0] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, list.get(0)[1], list.get(0)[1]});


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int i = cur[0];
            int pos = cur[1];
            int jump = cur[2];

            result = Math.max(result, pos);

            int next = i + 1;

            while (true) {
                if (list.size() <= next) {
                    break;
                }

                if (visited[next]) {
                    next++;
                    continue;
                }

                if (list.get(next)[0] > pos + jump) {
                    break;
                }

                visited[next] = true;
                int nextPos = list.get(next)[1];
                int nextJump = list.get(next)[1] - list.get(next)[0];
                q.offer(new int[]{next, nextPos, nextJump});
                next++;

            }

        }
        System.out.println(result);

    }
}