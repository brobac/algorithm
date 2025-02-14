import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int N = 10;
    static int[] answer = new int[N];
    static int[] select = new int[N];
    static int result = 0;


    static void solution(int cnt) {
        if (cnt == 10) {
            int correct = 0;
            for (int i = 0; i < N; i++) {
                if (answer[i] == select[i]) {
                    correct++;
                }
                if (correct == 5) {
                    result++;
                    break;
                }
            }

            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (2 <= cnt && select[cnt - 2] == i && select[cnt - 1] == i) continue;
            select[cnt] = i;
            solution(cnt + 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        solution(0);
        System.out.println(result);
    }
}