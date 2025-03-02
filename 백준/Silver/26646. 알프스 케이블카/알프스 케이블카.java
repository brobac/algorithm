import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] mountain = new int[N];
        for (int i = 0; i < N; i++) {
            mountain[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            result += mountain[i] * mountain[i] * 2 + mountain[i + 1] * mountain[i + 1] * 2;
        }

        System.out.println(result);
    }
}
