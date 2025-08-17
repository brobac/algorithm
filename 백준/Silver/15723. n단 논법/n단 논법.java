import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] childList = new ArrayList[26];
    static boolean[] visited;

    static boolean solution(int a, int b) {
        boolean result = false;
        visited[a] = true;

        for (int i = 0; i < childList[a].size(); i++) {
            int next = childList[a].get(i);
            if (childList[a].get(i) == b) {
                result = true;
                break;
            }
            if (visited[next]) continue;

            if (solution(next, b)) {
                result = true;
                break;
            }
        }
        visited[a] = false;

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[26];
        for (int i = 0; i < 26; i++) {
            childList[i] = new ArrayList<>();
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            int a = input[0] - 'a';
            int b = input[5] - 'a';

            childList[a].add(b);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            char[] input = br.readLine().toCharArray();
            int a = input[0] - 'a';
            int b = input[5] - 'a';

            System.out.println(solution(a, b) ? "T" : "F");
        }

    }
}