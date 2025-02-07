import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] students = new int[1000002];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            students[S]++;
            students[E + 1]--;
        }

        for (int i = 1; i <= 1000000; i++) {
            students[i] += students[i - 1];
        }

        StringBuilder result = new StringBuilder();

        int Q = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(st.nextToken());

            result.append(students[q]).append("\n");
        }

        System.out.println(result);
    }
}