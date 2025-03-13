import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a = 1;
        int b = 1;
        int c = 1;

        int year = 1;
        while (a != E || b != S || M != c) {
            a++;
            b++;
            c++;
            if (15 < a) a = 1;
            if (28 < b) b = 1;
            if (19 < c) c = 1;
            year++;
        }

        System.out.println(year);
    }
}