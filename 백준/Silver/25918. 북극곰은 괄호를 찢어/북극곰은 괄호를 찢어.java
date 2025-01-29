import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 1) {
            System.out.println(-1);
            return;
        }

        int maxDay = 0;
        Deque<Character> stack = new ArrayDeque<>();

        char[] input = br.readLine().toCharArray();

        for (char c : input) {
            if (stack.isEmpty()) {
                stack.push(c);
                maxDay = Math.max(maxDay, stack.size());
                continue;
            }

            if (stack.peek() == '(' && c == '(' || stack.peek() == ')' && c == ')') {
                stack.push(c);
                maxDay = Math.max(maxDay, stack.size());
                continue;
            }

            if (stack.peek() == '(' && c == ')' || stack.peek() == ')' && c == '(') {
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(maxDay);

    }
}