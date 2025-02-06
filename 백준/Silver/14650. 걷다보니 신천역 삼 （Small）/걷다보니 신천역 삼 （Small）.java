import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int result = 0;
    static int N;

    static void solution(int cnt, int num) {
        if (cnt == N) {
            if (num % 3 == 0) result++;
            return;
        }

        for (int i = 0; i <= 2; i++) {
            solution(cnt + 1, num * 10 + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }

        solution(1, 1);
        solution(1, 2);

        System.out.println(result);
    }
}