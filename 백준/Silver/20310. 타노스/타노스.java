import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int zero = 0;
        int one = 0;
        for (char c : s) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        int z = 0;
        int o = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            if (c == '0') {
                if (z < zero / 2) {
                    sb.append(0);
                    z++;
                }
            } else {
                if (one / 2 <= o) {
                    sb.append(1);
                } else {
                    o++;
                }
            }
        }

        System.out.println(sb);
    }
}