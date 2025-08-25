import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()) - 1;
        int R = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sortList = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = L; i <= R; i++) {
            sortList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(sortList);
        for (int v : sortList) {
            list.add(v);
        }
        for (int i = R + 1; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < N; i++) {
            if (list.get(i - 1) <= list.get(i)) continue;

            System.out.println(0);
            return;
        }

        System.out.println(1);

    }
}