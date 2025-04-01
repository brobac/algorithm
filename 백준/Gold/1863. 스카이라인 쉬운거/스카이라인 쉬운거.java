import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        stack.push(0);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (stack.peek() < y) {
                stack.push(y);
            } else {
                while (!stack.isEmpty() && y < stack.peek()) {
                    result++;
                    stack.pop();
                }
                if (stack.peek() < y) {
                    stack.push(y);
                }
            }
        }
        while (!stack.isEmpty() && 0 < stack.peek()) {
            result++;
            stack.pop();

        }

        System.out.println(result);
    }
}