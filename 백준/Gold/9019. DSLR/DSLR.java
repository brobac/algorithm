import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        test:
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            boolean[] checked = new boolean[10000];

            while (true) {
                Queue<Snap> q = new ArrayDeque<>();
                checked[A] = true;
                Snap a = new Snap(A);
                q.offer(a);

                while (!q.isEmpty()) {
                    Snap cur = q.poll();

                    if (cur.num == B) {
                        for (char c : cur.opList) {
                            sb.append(c);
                        }
                        sb.append("\n");
                        continue test;
                    }

                    int nextNum = cur.num * 2 % 10000;
                    if (!checked[nextNum]) {
                        checked[nextNum] = true;
                        Snap d = new Snap(nextNum);
                        d.opList = new ArrayList<>(cur.opList);
                        d.opList.add('D');
                        q.offer(d);
                    }


                    nextNum = cur.num == 0 ? 9999 : cur.num - 1;
                    if (!checked[nextNum]) {
                        checked[nextNum] = true;
                        Snap s = new Snap(nextNum);
                        s.opList = new ArrayList<>(cur.opList);
                        s.opList.add('S');
                        q.offer(s);

                    }

                    int v = cur.num;
                    int[] temp = new int[4];
                    for (int i = 3; 0 <= i; i--) {
                        temp[i] = v % 10;
                        v /= 10;
                    }
                    nextNum = temp[1] * 1000 + temp[2] * 100 + temp[3] * 10 + temp[0];

                    if (!checked[nextNum]) {
                        checked[nextNum] = true;
                        Snap l = new Snap(nextNum);
                        l.opList = new ArrayList<>(cur.opList);
                        l.opList.add('L');
                        q.offer(l);
                    }
                    nextNum = temp[3] * 1000 + temp[0] * 100 + temp[1] * 10 + temp[2];

                    if (!checked[nextNum]) {
                        checked[nextNum] = true;
                        Snap r = new Snap(nextNum);
                        r.opList = new ArrayList<>(cur.opList);
                        r.opList.add('R');
                        q.offer(r);
                    }
                }


            }
        }

        System.out.println(sb);

    }

    static class Snap {
        int num;
        ArrayList<Character> opList;

        public Snap(int num) {
            this.num = num;
            opList = new ArrayList<>();
        }
    }
}