import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] inCount = new int[N + 1];

        ArrayList<int[]>[] nextList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nextList[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            nextList[Y].add(new int[]{X, K});
            inCount[X]++;
        }

        TreeMap<Integer, Integer>[] baseMap = new TreeMap[N + 1];
        for (int i = 1; i <= N; i++) {
            baseMap[i] = new TreeMap<>();
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (inCount[i] == 0) {
                baseMap[i].put(i, 1);
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == N) break;


            for (int[] next : nextList[cur]) {
                int nextNumber = next[0];
                int count = next[1];

                for (Map.Entry<Integer, Integer> entry : baseMap[cur].entrySet()) {
                    baseMap[nextNumber].put(entry.getKey(), baseMap[nextNumber].getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }

                inCount[nextNumber]--;
                if (inCount[nextNumber] == 0) {
                    q.offer(nextNumber);
                }


            }


        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : baseMap[N].entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb);


    }
}