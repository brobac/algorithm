import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String paper = br.readLine();
            int j = 0;
            while (j < paper.length()) {
                if (!isNumber(paper.charAt(j))) {
                    j++;
                    continue;
                }

                int end = j + 1;
                while (end < paper.length() && isNumber(paper.charAt(end))) {
                    end++;

                }

                int start = j;
                while (start < end - 1 && paper.charAt(start) == '0') {
                    start++;
                }
                String numString = paper.substring(start, end);
                j = end;
                list.add(numString);
            }
        }
        list.sort((a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return Integer.compare(a.length(), b.length());
        });
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}