import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        if (N == 1 && M == 1) {
            System.out.println("1\n1");
            return;
        }


        if (N == 1 || M == 1) {
            sb.append("2\n");
        } else {
            sb.append("4\n");
        }


        if (M == 1) {
            for (int r = 0; r < N; r++) {
                sb.append(r % 2 == 0 ? "1\n" : "2\n");
            }
        } else {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (r % 2 == 0) {
                        if (c % 2 == 0) {
                            sb.append("1 ");
                        } else {
                            sb.append("2 ");
                        }
                    } else {
                        if (c % 2 == 0) {
                            sb.append("3 ");
                        } else {
                            sb.append("4 ");
                        }
                    }
                }
                sb.append("\n");
            }

        }


        System.out.println(sb);
    }
}