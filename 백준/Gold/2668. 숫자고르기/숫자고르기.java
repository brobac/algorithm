import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N, count;
    static int[] nums;
    static boolean[] visited, result;
    static ArrayList<Integer> list;

    static void solution(int start, int cur) {
        visited[cur] = true;
        list.add(cur);
        int next = nums[cur];
        if (next == start) {
            count += list.size();
            for (int v : list) {
                result[v] = true;
            }

        } else if (!result[next] && !visited[next]) {
            solution(start, next);
        }

        visited[cur] = false;
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        count = 0;
        nums = new int[N + 1];
        visited = new boolean[N + 1];
        result = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (result[i]) continue;
            solution(i, i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for (int i = 1; i <= N; i++) {
            if (result[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }
}