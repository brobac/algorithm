import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static boolean[] make;

    static void solution(int cnt, int sum) {
        if (cnt == N) {
            make[sum] = true;
            return;
        }

        solution(cnt + 1, sum + num[cnt]);
        solution(cnt + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        make = new boolean[2000000];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);

        for (int i = 1; i <= 2000000; i++) {
            if (!make[i]) {
                System.out.println(i);
                return;
            }
        }
    }


}