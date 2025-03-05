import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String before = st.nextToken();
            char after = st.nextToken().charAt(0);
            map.put(after, before);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : br.readLine().toCharArray()) {
            sb.append(map.get(c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(sb.substring(S - 1, E));

    }
}