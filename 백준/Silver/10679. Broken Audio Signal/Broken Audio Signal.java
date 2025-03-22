import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int X = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dataset:
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] samples = new int[N];


            for (int i = 0; i < N; i++) {
                String v = st.nextToken();
                if (v.equals("x")) {
                    samples[i] = X;
                } else {
                    samples[i] = Integer.parseInt(v);
                }
            }


            if (N == 1) {
                sb.append("ambiguous\n");
                continue;
            }

            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;


            // 첫번째 샘플
            if (samples[0] == X) {
                if (samples[1] == X) {
                    sb.append("none\n");
                    continue;
                }

                max = samples[1] - 1;
            } else {
                if (samples[1] != X && samples[1] <= samples[0]) {
                    sb.append("none\n");
                    continue;
                }
            }

            // 가운데 샘플

            for (int i = 1; i < N - 1; i++) {
                if (samples[i] != X) {
                    if (i % 2 == 0) {
                        if (samples[i - 1] != X && samples[i - 1] <= samples[i] || samples[i + 1] != X && samples[i + 1] <= samples[i]) {
                            sb.append("none\n");
                            continue dataset;
                        }
                    } else {
                        if (samples[i - 1] != X && samples[i - 1] >= samples[i] || samples[i + 1] != X && samples[i + 1] >= samples[i]) {
                            sb.append("none\n");
                            continue dataset;
                        }

                    }
                    continue;
                }

                if (i % 2 == 0) {
                    if (samples[i + 1] == X) {
                        sb.append("none\n");
                        continue dataset;
                    }
                    max = Math.min(max, Math.min(samples[i + 1] - 1, samples[i - 1] - 1));


                } else {
                    if (samples[i + 1] == X) {
                        sb.append("none\n");
                        continue dataset;
                    }
                    min = Math.max(min, Math.max(samples[i + 1] + 1, samples[i - 1] + 1));

                }
            }


            // 마지막 샘플

            if (samples[N - 1] == X) {
                if ((N - 1) % 2 == 0) {
                    max = Math.min(max, samples[N - 2] - 1);
                } else {
                    min = Math.max(min, samples[N - 2] + 1);
                }
            } else {
                if ((N - 1) % 2 == 0) {
                    if (samples[N - 2] != X && samples[N - 2] <= samples[N - 1]) {
                        sb.append("none\n");
                        continue;
                    }
                } else {
                    if (samples[N - 2] != X && samples[N - 2] >= samples[N - 1]) {
                        sb.append("none\n");
                        continue;
                    }
                }
            }


            if (min == max) {
                sb.append(min).append("\n");
            } else if (min < max) {
                sb.append("ambiguous\n");
            } else {
                sb.append("none\n");
            }

        }
        System.out.println(sb);
    }
}