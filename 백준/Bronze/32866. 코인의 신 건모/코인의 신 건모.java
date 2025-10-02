import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());
        double X = Double.parseDouble(br.readLine());

        System.out.println(((N / (N * (100 - X))) * 100 - 1) * 100);

    }
}