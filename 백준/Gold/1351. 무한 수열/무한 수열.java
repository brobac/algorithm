import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static
    Map<Long, Long> map;
    static long N, P, Q;

    static long solution(long n) {
        if (n == 0) {
            return 1;
        }

        if (!map.containsKey(n / P)) {
            map.put(n / P, solution(n / P));
        }

        if (!map.containsKey(n / Q)) {
            map.put(n / Q, solution(n / Q));
        }

        return map.get(n / P) + map.get(n / Q);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);
        System.out.println(solution(N));
    }
}