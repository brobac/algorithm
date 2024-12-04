import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            char c = st.nextToken().charAt(0);
            double target = Double.parseDouble(st.nextToken());
            int result = 6;
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(a, 0, 'A'));
            list.add(new Pair(b, 0, 'B'));

            double temp = a;
            int time = 1;

            // a감소
            for (int i = 1; i <= 5; i++) {
                temp -= 0.02;
                temp = Math.round(temp * 1000.0) / 1000.0;
                if (temp < 144) {
                    temp = 146.000;
                }
                list.add(new Pair(temp, time++, 'A'));
            }
            temp = a;
            time = 1;
            for (int i = 1; i <= 5; i++) {
                temp += 0.02;
                temp = Math.round(temp * 1000.0) / 1000.0;

                if (146 < temp) {
                    temp = 144.000;
                }
                list.add(new Pair(temp, time++, 'A'));
            }

            temp = b;
            time = 1;

            // a감소
            for (int i = 1; i <= 5; i++) {
                temp -= 0.02;
                temp = Math.round(temp * 1000.0) / 1000.0;

                if (temp < 144) {
                    temp = 146.000;
                }
                list.add(new Pair(temp, time++, 'B'));
            }
            temp = b;
            time = 1;
            for (int i = 1; i <= 5; i++) {
                temp += 0.02;
                temp = Math.round(temp * 1000.0) / 1000.0;
                if (146 < temp) {
                    temp = 144.000;
                }
                list.add(new Pair(temp, time++, 'B'));
            }

            for (Pair p : list) {
                if (p.channel != c) {
                    p.time++;
                }
                if (p.frequency == target && p.time < result) {
                    result = p.time;
                }
            }
            bw.write(Integer.toString(result));
            bw.newLine();
        }
        bw.flush();
    }

    static class Pair {
        double frequency;
        int time;
        char channel;

        public Pair(double frequency, int time, char channel) {
            this.frequency = frequency;
            this.time = time;
            this.channel = channel;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "frequency=" + frequency +
                    ", time=" + time +
                    ", channel=" + channel +
                    '}';
        }
    }
}
