import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] letters = new String[N];

        int prev = 0;

        Set<String> set = new HashSet<>();

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            int next = (prev + c) % N;


            if (letters[next] == null) {
                if (set.contains(s)) {
                    System.out.println("!");
                    return;
                }
                letters[next] = s;
                prev = next;
                set.add(s);

            } else if (letters[next].equals(s)) {
                prev = next;
            } else {
                System.out.println("!");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while (n < N) {
            n++;

            sb.append(letters[prev] == null ? "?" : letters[prev]);
            if (prev - 1 < 0) {
                prev = N - 1;
            } else {
                prev--;
            }
        }
        System.out.println(sb);
    }
}