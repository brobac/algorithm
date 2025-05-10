import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MAX = 1000000;
        int[] res = new int[MAX + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= MAX; i++) {
            res[i] = (res[i - 2] + res[i - 1]) % 15746;
        }
        System.out.println(res[N]);
    }
}