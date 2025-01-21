import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] used = new boolean[N + 1];

        int[][] students = new int[N][5];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 4; i++) {
            int result = 0;
            int topScore = -1;

            for (int[] student : students) {
                int no = student[0];
                if (used[no]) continue;

                if (topScore < student[i]) {
                    result = no;
                    topScore = student[i];
                } else if (topScore == student[i] && no < result) {
                    result = no;
                }
            }

            used[result] = true;
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }
}