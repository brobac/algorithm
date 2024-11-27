import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] c = new boolean[6][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            c[a][b] = true;
            c[b][a] = true;
        }

        System.out.println(c[1][3] && c[1][4] && c[3][4] && !c[1][2] && !c[1][5] && !c[2][3] && !c[2][4] && !c[2][5] && !c[3][5] && !c[4][5] ? "Wa-pa-pa-pa-pa-pa-pow!" : "Woof-meow-tweet-squeek");
    }
}