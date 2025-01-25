import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final int MOD = 1000000;
    static Map<String, Integer> memo = new HashMap<>();

    static int solution(String s) {
        if (s.charAt(0) == '0') return 0;
        if (memo.containsKey(s)) return memo.get(s);
        if (s.length() == 1) {
            memo.put(s, 1);
            return 1;
        }
        if (s.length() == 2) {
            int n = Integer.parseInt(s);

            if (n == 10 || n == 20) {
                memo.put(s, 1);
                return 1;
            }
            if (1 <= n && n <= 26) {
                memo.put(s, 2);
                return 2;
            }

            if (s.charAt(0) == '0' || s.charAt(1) == '0') {
                memo.put(s, 0);
                return 0;
            }
            memo.put(s, 1);
            return 1;
        }

        int n = Integer.parseInt(s.substring(0, 2));

        if (1 <= n && n <= 26) {

            if (n == 10 || n == 20) {
                int result = solution(s.substring(2)) % MOD;
                memo.put(s, result);
                return result;
            }

            int result = (solution(s.substring(1)) + solution(s.substring(2))) % MOD;
            memo.put(s, result);
            return result;
        }
        int result = solution(s.substring(1)) % MOD;
        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(solution(input));
    }
}