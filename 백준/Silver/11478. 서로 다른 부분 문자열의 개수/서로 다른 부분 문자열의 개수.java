import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 1; i + j <= N; j++) {
                set.add(input.substring(i, i + j));
            }
        }

        System.out.println(set.size());
    }
}