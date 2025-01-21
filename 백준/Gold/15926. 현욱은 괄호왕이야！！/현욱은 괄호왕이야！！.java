import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int result = 0;
        int lastInvalid = -1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            char c = input[i];

            if (c == '(') {
                stack.push(i);
                continue;
            }

            if (stack.isEmpty()) {
                lastInvalid = i;
                continue;
            }

            stack.pop();
            if (stack.isEmpty()) {
                result = Math.max(result, i - lastInvalid);
            } else {
                result = Math.max(result, i - stack.peek());
            }
        }

        System.out.println(result);
    }
}