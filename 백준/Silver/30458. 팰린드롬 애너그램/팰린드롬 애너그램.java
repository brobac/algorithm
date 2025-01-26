import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < N / 2; i++) {
            count.put(input[i], count.getOrDefault(input[i], 0) + 1);
        }
        for (int i = (N + 1) / 2; i < N; i++) {
            count.put(input[i], count.getOrDefault(input[i], 0) + 1);
        }

        for (int v : count.values()) {
            if (v % 2 != 0) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}