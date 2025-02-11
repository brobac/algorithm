import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] lcs = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        if (lcs[a.length][b.length] == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lcs[a.length][b.length]).append("\n");

        int i = a.length;
        int j = b.length;
        Deque<Character> q = new ArrayDeque<>();
        while (0 < lcs[i][j]) {
            if (lcs[i][j] == lcs[i - 1][j]) {
                i--;
                continue;
            }
            if (lcs[i][j] == lcs[i][j - 1]) {
                j--;
                continue;
            }
            q.push(a[i - 1]);
            i--;
            j--;

        }

        while (!q.isEmpty()) {
            sb.append(q.pop());
        }

        System.out.println(sb);
    }
}