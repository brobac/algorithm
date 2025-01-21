import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ball = new int[N];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            for (int j = L - 1; j < R; j++) {
                ball[j] = i;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int n : ball) {
            set.add(n);
        }
        set.remove(0);

        System.out.println((long) Math.pow(2, set.size()));
    }
}