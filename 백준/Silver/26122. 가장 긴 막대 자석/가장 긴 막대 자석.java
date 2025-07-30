import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        ArrayList<Integer> list = new ArrayList<>();

        char c = input[0];
        int len = 1;


        for (int i = 1; i < K; i++) {
            if (input[i] == c) {
                len++;
            } else {
                c = input[i];
                list.add(len);
                len = 1;
            }
        }

        list.add(len);

        if (list.size() == 1) {
            System.out.println(0);
            return;
        }

        int result = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            result = Math.max(result, Math.min(list.get(i), list.get(i + 1)) * 2);

        }
        System.out.println(result);
    }
}