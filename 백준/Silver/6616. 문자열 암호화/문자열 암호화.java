import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            char[] input = br.readLine().toCharArray();
            int resultLength = 0;
            for (char c : input) {
                if (c != ' ') resultLength++;
            }

            char[] result = new char[resultLength];

            boolean[] used = new boolean[resultLength];
            int idx = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == ' ') continue;
                result[idx] = input[i];
                used[idx] = true;

                idx += N;

                if (resultLength <= idx) {
                    for (int j = 0; j < resultLength; j++) {
                        if (!used[j]) {
                            idx = j;
                            break;
                        }
                    }
                }

            }

            for (char c : result) {
                sb.append(Character.toUpperCase(c));
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }
}