import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(A);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(A.get(i))) continue;

            map.put(A.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int D = Integer.parseInt(br.readLine());
            sb.append(map.getOrDefault(D, -1)).append("\n");

        }

        System.out.println(sb);
    }
}