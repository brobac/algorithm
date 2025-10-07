import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[26];

        outer:
        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().split(" ");

            for (int j = 0; j < words.length; j++) {

                int first = Character.isLowerCase(words[j].charAt(0)) ? words[j].charAt(0) - 'a' : words[j].charAt(0) - 'A';
                if (!used[first]) {
                    used[first] = true;
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);

                    for (String s : words) {
                        sb.append(s).append(" ");
                    }
                    sb.append("\n");
                    continue outer;
                }
            }

            for (int j = 0; j < words.length; j++) {
                for (int k = 1; k < words[j].length(); k++) {
                    int idx = Character.isLowerCase(words[j].charAt(k)) ? words[j].charAt(k) - 'a' : words[j].charAt(k) - 'A';
                    if (!used[idx]) {
                        used[idx] = true;
                        words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);

                        for (String s : words) {
                            sb.append(s).append(" ");
                        }
                        sb.append("\n");
                        continue outer;
                    }
                }
            }
            for (String s : words) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}