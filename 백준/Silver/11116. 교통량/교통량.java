import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int result = 0;
            int m = Integer.parseInt(br.readLine());
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                left.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                right.add(Integer.parseInt(st.nextToken()));
            }

            for (int v : left) {
                if (left.contains(v + 500) && right.contains(v + 1000) && right.contains(v + 1500)) result++;
            }


            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}