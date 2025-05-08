import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int result = Math.abs(A - B);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            result = Math.min(result, Math.abs(B - v) + 1);
        }
        System.out.println(result);
    }
}