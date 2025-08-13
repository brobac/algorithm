import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int solution(int a, int b) {
        while (a != b) {
            if (a < b) {
                b /= 2;
            } else {
                a /= 2;
            }
        }

        return a * 10;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (; 0 < T; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(solution(A, B)).append("\n");
        }

        System.out.println(sb);
    }
}