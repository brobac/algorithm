import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        long maxLength = 0;
        long count = 0;

        for (int i = 0; i < N; i++) {
            long length = Arrays.stream(br.readLine().split("0")).filter(v -> !v.isEmpty()).count();
            if (maxLength < length) {
                maxLength = length;
                count = 1;
            } else if (maxLength == length) {
                count++;
            }
        }

        System.out.println(maxLength + " " + count);
    }
}