import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static StringBuilder result = new StringBuilder();
    static boolean[] used;

    static void find(int start, int end) {
        if (end < start) return;

        if (start == end) {
            used[start] = true;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (used[i]) sb.append(input.charAt(i));
            }
            result.append(sb).append("\n");
            return;
        }

        int min = start;
        for (int i = start + 1; i <= end; i++) {
            if (input.charAt(i) < input.charAt(min)) {
                min = i;
            }
        }

        used[min] = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (used[i]) sb.append(input.charAt(i));
        }
        result.append(sb).append("\n");

        find(min + 1, end);
        find(start, min - 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        used = new boolean[input.length()];
        find(0, input.length() - 1);

        System.out.println(result);

    }
}