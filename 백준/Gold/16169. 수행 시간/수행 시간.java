import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        ArrayList<int[]>[] list = new ArrayList[N + 1];
        int[] end = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[level].add(new int[]{i, t});

        }

        for (int i = 1; i <= N && !list[i].isEmpty(); i++) {
            for (int[] cur : list[i]) {
                int curNumber = cur[0];
                int curT = cur[1];
                for (int[] prev : list[i - 1]) {
                    int prevNumber = prev[0];
                    end[curNumber] = Math.max(end[curNumber], end[prevNumber] + (int) Math.pow(Math.abs(curNumber - prevNumber), 2));
                }
                end[curNumber] += curT;

                result = Math.max(result, end[curNumber]);
            }
        }

        System.out.println(result);
    }
}