import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[N + 1];


        ArrayList<Item> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int student = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            list.add(new Item(country, student, score));
        }

        Collections.sort(list);

        int win = 0;
        for (int i = 0; i < N && win < 3; i++) {
            Item cur = list.get(i);
            if (count[cur.country] == 2) continue;
            count[cur.country]++;
            System.out.println(cur.country + " " + cur.student);
            win++;
        }


    }

    static class Item implements Comparable<Item> {
        int country, student, score;

        public Item(int country, int student, int score) {
            this.country = country;
            this.student = student;
            this.score = score;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(o.score, score);
        }
    }
}