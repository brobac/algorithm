import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        List<Character> string = new ArrayList<>();
        add:
        for (char c : input) {
            string.add(c);
            if (string.size() < bomb.length) continue;

            for (int i = 0; i < bomb.length; i++) {
                if (string.get(string.size() - bomb.length + i) != bomb[i]) continue add;
            }

            for (int i = 0; i < bomb.length; i++) {
                string.remove(string.size() - 1);
            }

        }


        if (string.size() == 0) {
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : string) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}