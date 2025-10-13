import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> cheeseSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            if (s.endsWith("Cheese")) {
                cheeseSet.add(s);
            }

        }

        System.out.println(cheeseSet.size() < 4 ? "sad" : "yummy");


    }
}