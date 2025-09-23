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
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        Set<String> win = new HashSet<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String result = st.nextToken();

            if (result.equals("W")) {
                win.add(name);
            }
        }

        int score = 0;

        for (int i = 0; i < N; i++) {
            if (win.contains(br.readLine())) {
                score += W;
                if (G <= score) {
                    System.out.println("I AM NOT IRONMAN!!");
                    return;
                }
            } else {
                score = Math.max(score - L, 0);
            }
        }

        System.out.println("I AM IRONMAN!!");


    }
}