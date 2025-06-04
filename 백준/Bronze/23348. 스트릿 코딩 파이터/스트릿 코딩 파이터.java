import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] level = new int[3];
        for (int i = 0; i < 3; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        while (N-- > 0) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    sum += Integer.parseInt(st.nextToken()) * level[j];
                }
            }
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}