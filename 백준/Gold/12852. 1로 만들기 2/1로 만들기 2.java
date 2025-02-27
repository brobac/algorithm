import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prev = new int[N + 1];

        prev[N] = -1;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int v = q.poll();


            if (v == 1) {
                break;
            }

            if (v % 3 == 0 && prev[v / 3] == 0) {
                prev[v / 3] = v;
                q.offer(v / 3);
            }

            if (v % 2 == 0 && prev[v / 2] == 0) {
                prev[v / 2] = v;
                q.offer(v / 2);
            }

            if (prev[v - 1] == 0) {
                prev[v - 1] = v;
                q.offer(v - 1);
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        int idx = 1;
        while (prev[idx] != -1) {
            stack.push(prev[idx]);
            idx = prev[idx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stack.size() - 1).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}