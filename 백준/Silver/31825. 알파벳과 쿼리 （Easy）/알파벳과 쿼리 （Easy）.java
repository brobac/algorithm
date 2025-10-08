import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int getGroupCount(String s) {
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                c = s.charAt(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        String S = br.readLine();

        while (0 < Q--) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;

            if (op == 1) {
                sb.append(getGroupCount(S.substring(l, r + 1))).append("\n");
            } else {
                char[] temp = S.toCharArray();
                for (int i = l; i <= r; i++) {
                    temp[i] = (char) ((temp[i] - 'A' + 1) % 26 + 'A');
                }
                S = new String(temp);
            }
        }

        System.out.println(sb);
    }
}