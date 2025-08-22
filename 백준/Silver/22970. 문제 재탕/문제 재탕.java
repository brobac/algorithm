import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken());
        boolean up = true;
        int result = 1;
        int count = 1;
        for (int i = 0; i < N - 1; i++) {
            int next = Integer.parseInt(st.nextToken());

            if (up && cur < next) {
                count++;
            } else if (up && next < cur) {
                count++;
                up = false;
            } else if (!up && next < cur) {
                count++;
            } else if (!up && cur < next) {
                count = 2;
                up = true;
            } else {
                count = 1;
                up = true;
            }
            cur = next;
            result = Math.max(result, count);
        }
        System.out.println(result);
    }
}