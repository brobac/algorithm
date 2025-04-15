import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] workTime = new int[N + 1];
        int[] pendingTime = new int[N + 1];
        int[] inCount = new int[N + 1];
        ArrayList<Integer>[] nextList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nextList[i] = new ArrayList<>();
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            workTime[i] = Integer.parseInt(st.nextToken());
            inCount[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < inCount[i]; j++) {
                int prev = Integer.parseInt(st.nextToken());
                nextList[prev].add(i);
            }

            if (inCount[i] == 0) {
                q.offer(i);
            }
        }

        int result = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            int endTime = workTime[cur] + pendingTime[cur];
            result = Math.max(result, endTime);

            for (int next : nextList[cur]) {
                inCount[next]--;
                pendingTime[next] = Math.max(pendingTime[next], endTime);

                if (inCount[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(result);
    }
}