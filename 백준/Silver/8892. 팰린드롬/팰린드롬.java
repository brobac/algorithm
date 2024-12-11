import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        testCase:
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }

            for (int i = 0; i < N - 1; i++) {
                find:
                for (int j = i + 1; j < N; j++) {
                    String a = String.join("", words[i], words[j]);
                    String b = String.join("", words[j], words[i]);
                    boolean aSuccess = true;
                    for (int k = 0; k < a.length() / 2; k++) {
                        if (a.charAt(k) != a.charAt(a.length() - 1 - k)) {
                            aSuccess = false;
                            break;
                        }
                    }
                    if (aSuccess) {
                        sb.append(a).append("\n");
                        continue testCase;
                    }
                    for (int k = 0; k < b.length() / 2; k++) {
                        if (b.charAt(k) != b.charAt(b.length() - 1 - k)) continue find;
                    }
                    sb.append(b).append("\n");
                    continue testCase;
                }
            }
            sb.append("0\n");
        }
        System.out.println(sb);
    }
}