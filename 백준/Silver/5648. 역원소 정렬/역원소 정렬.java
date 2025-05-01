import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] res = new long[N];
        int cnt = 0;
        while (cnt < N) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                res[cnt++] = Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString());
            }
        }
        Arrays.sort(res);

        for (long v : res) {
            bw.write(v + "\n");
        }
        bw.flush();
    }
}