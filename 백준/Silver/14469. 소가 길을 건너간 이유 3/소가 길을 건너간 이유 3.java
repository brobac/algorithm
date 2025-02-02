import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> cowList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cowList.add(new int[]{a, b});
        }
        cowList.sort(Comparator.comparingInt(a -> a[0]));

        int time = 0;

        for (int[] cow : cowList) {
            if (time < cow[0]) {
                time = cow[0] + cow[1];
            } else {
                time += cow[1];
            }
        }
        System.out.println(time);
    }
}