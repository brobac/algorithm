import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                list.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }
        }

        int idx = 0;
        while (1 < list.size()) {
            int v = list.remove(idx)[1];
            idx = (idx + v - 1) % list.size();
        }

        System.out.println(list.get(0)[0] + " " + list.get(0)[1]);
    }
}