import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        String input = br.readLine();
        set.add(input);
        int sr = input.charAt(0) - 'A';
        int sc = Character.getNumericValue(input.charAt(1));
        int cr = sr;
        int cc = sc;
        int nr = 0;
        int nc = 0;
        trip:
        for (int i = 0; i < 35; i++) {
            input = br.readLine();
            set.add(input);
            nr = input.charAt(0) - 'A';
            nc = Character.getNumericValue(input.charAt(1));

            for (int d = 0; d < 8; d++) {
                if (cr + dr[d] == nr && cc + dc[d] == nc) {
                    cr = nr;
                    cc = nc;
                    continue trip;
                }
            }

            System.out.println("Invalid");
            return;
        }

        if (set.size() != 36) {
            System.out.println("Invalid");
            return;
        }
        for (int d = 0; d < 8; d++) {
            if (nr + dr[d] == sr && nc + dc[d] == sc) {
                System.out.println("Valid");
                return;
            }
        }

        System.out.println("Invalid");
    }
}