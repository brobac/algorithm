import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();

        char last = ' ';
        int idx = N - 1;
        for (; 0 <= idx; idx--) {
            if (!isVowel(input[idx])) {
                last = input[idx];
                idx--;
                break;
            }
        }

        int aCount = 0;
        while (0 <= idx && aCount < 2) {
            if (input[idx] == 'A') {
                aCount++;
            }
            idx--;
        }

        if (aCount < 2 || idx < M - 4) {
            System.out.println("NO");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("YES\n");
            for (int i = 0; i < M - 3; i++) {
                sb.append(input[i]);
            }
            sb.append("AA").append(last);
            System.out.println(sb);

        }

    }
}