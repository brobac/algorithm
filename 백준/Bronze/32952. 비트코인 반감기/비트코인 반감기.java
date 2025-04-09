import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long R = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());


        System.out.println(R / (long) Math.pow(2, M / K));

    }
}