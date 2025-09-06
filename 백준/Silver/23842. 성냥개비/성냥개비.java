import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] count = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    static String toPrintNumber(int n) {
        if (n < 10) {
            return "0" + n;
        } else {
            return Integer.toString(n);
        }
    }

    static int getRequireCount(int n) {
        if (n < 10) {
            return count[0] + count[n];
        } else {
            return count[n / 10] + count[n % 10];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 99; i++) {
            for (int j = 0; i + j <= 99; j++) {
                int require = getRequireCount(i) + getRequireCount(j) + getRequireCount(i + j) + 4;
                if (require == N) {
                    System.out.println(toPrintNumber(i) + "+" + toPrintNumber(j) + "=" + toPrintNumber(i + j));
                    return;
                }
            }
        }

        System.out.println("impossible");
    }
}
