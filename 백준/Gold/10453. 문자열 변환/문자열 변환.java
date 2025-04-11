import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();

            if (A.length != B.length) {
                sb.append("-1\n");
                continue;
            }

            ArrayList<Integer>[] list = new ArrayList[2];
            list[0] = new ArrayList<>();
            list[1] = new ArrayList<>();

            for (int i = 1; i < A.length - 1; i++) {
                if (A[i] != B[i]) {
                    list[A[i] - 'a'].add(i);
                }
            }

            if (list[0].size() != list[1].size()) {
                sb.append("-1\n");
                continue;
            }

            int count = 0;
            for (int i = 0; i < list[0].size(); i++) {
                count += Math.abs(list[0].get(i) - list[1].get(i));
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}