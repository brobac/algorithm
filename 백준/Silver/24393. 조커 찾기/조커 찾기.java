import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cards = new int[28];
        for (int i = 1; i <= 27; i++) {
            cards[i] = i;
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 1;
            int left = 1;
            int right = 14;
            int idx = 1;
            int[] temp = new int[28];
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                if (j % 2 == 1) {
                    for (int k = 0; k < v; k++) {
                        temp[idx++] = cards[right++];
                    }
                } else {
                    for (int k = 0; k < v; k++) {
                        temp[idx++] = cards[left++];
                    }
                }
                j++;
            }
            cards = temp;
        }
        for (int i = 1; i <= 27; i++) {
            if (cards[i] == 1) {
                System.out.println(i);
            }
        }
    }
}