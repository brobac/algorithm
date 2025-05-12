import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (; 0 < T; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            ArrayList<Integer> xList = new ArrayList<>();
            ArrayList<Integer> yList = new ArrayList<>();
            while (0 < X) {
                xList.add(X % B);
                X /= B;
            }

            while (0 < Y) {
                yList.add(Y % B);
                Y /= B;
            }

            if (xList.size() < yList.size()) {
                while (0 < yList.size() - xList.size()) {
                    xList.add(0);
                }
            } else if (yList.size() < xList.size()) {
                while (0 < xList.size() - yList.size()) {
                    yList.add(0);
                }
            }

            int result = 0;
            for (int i = xList.size() - 1; 0 <= i; i--) {
                result += (int) (((xList.get(i) + yList.get(i)) % B) * Math.pow(B, i));
            }

            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
}