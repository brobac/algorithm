import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] t = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(t);

        long sum = 0;
        long count = 0;
        P--;
        int i = 0;
        while (i < N && 0 <= P - t[i]) {
            count++;
            sum += P;
            P -= t[i];
            i++;
        }
        System.out.println(count + " " + sum);

    }
}