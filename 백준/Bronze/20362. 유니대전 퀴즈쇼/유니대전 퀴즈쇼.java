import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String S = st.nextToken();
        String[] chat = new String[N];
        int idx = 0;
        String answer = "";
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String c = st.nextToken();

            chat[i] = c;
            if (S.equals(name)) {
                idx = i;
                answer = c;
                break;
            }
        }

        int result = 0;
        for (int i = 0; i < idx; i++) {
            if (chat[i].equals(answer)) result++;
        }
        System.out.println(result);
    }
}