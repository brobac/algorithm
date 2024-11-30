import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] skWin = new boolean[1001];

    static {
        skWin[1] = true;
        skWin[3] = true;
        skWin[4] = true;
        skWin[5] = true;

        for (int i = 6; i <= 1000; i++) {
            if (skWin[i - 1] && skWin[i - 3] && skWin[i - 4]) {
                skWin[i] = false;
            } else {
                skWin[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(skWin[N] ? "SK" : "CY");

    }
}