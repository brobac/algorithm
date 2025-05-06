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
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        boolean[] formSubmit = new boolean[N + 1];

        ArrayList<int[]> missList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> resultList = new ArrayList<>();

        for (; 0 < M; M--) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());


            if (t == 0) {
                //form submit;

                for (int j = missList.size() - 1; 0 <= j; j--) {
                    if (i == missList.get(j)[0]) {
                        missList.remove(j);
                        continue;
                    }
                    missList.get(j)[1]++;
                    if (missList.get(j)[1] == S) {
                        resultList.add(missList.get(j)[0]);
                        missList.remove(j);
                    }
                }
                formSubmit[i] = true;
            } else if (!formSubmit[i]) {
                missList.add(new int[]{i, 0});
            }
        }

        if (resultList.isEmpty()) {
            sb.append("-1");
        }

        Collections.sort(resultList);
        for (int v : resultList) {
            sb.append(v).append("\n");
        }


        System.out.println(sb);
    }
}