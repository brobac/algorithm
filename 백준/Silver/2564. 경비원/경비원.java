import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[][] stores = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i][0] = Integer.parseInt(st.nextToken());
            stores[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        int result = 0;

        for (int[] store : stores) {
            int sd = store[1];
            switch (n) {
                case 1: {
                    switch (store[0]) {
                        case 1: {
                            result += Math.abs(d - sd);
                            continue;
                        }
                        case 2: {
                            result += R + Math.min(d + sd, C + C - d - sd);
                            continue;
                        }

                        case 3: {
                            result += d + sd;
                            continue;
                        }
                        case 4: {
                            result += C - d + sd;
                            continue;
                        }
                    }
                }
                case 2: {
                    switch (store[0]) {
                        case 1: {
                            result += R + Math.min(d + sd, C + C - d - sd);
                            continue;
                        }
                        case 2: {
                            result += Math.abs(d - sd);
                            continue;
                        }
                        case 3: {
                            result += d + R - sd;
                            continue;
                        }
                        case 4: {
                            result += C - d + R - sd;
                            continue;
                        }
                    }
                }
                case 3: {
                    switch (store[0]) {
                        case 1: {
                            result += d + sd;
                            continue;
                        }
                        case 2: {
                            result += R - d + sd;
                            continue;
                        }

                        case 3: {
                            result += Math.abs(d - sd);
                            continue;
                        }
                        case 4: {
                            result += C + Math.min(d + sd, R + R - d - sd);
                            continue;
                        }
                    }
                    break;
                }

                case 4: {
                    switch (store[0]) {
                        case 1: {
                            result += d + C - sd;
                            continue;
                        }
                        case 2: {
                            result += R - d + C - sd;
                            continue;
                        }

                        case 3: {
                            result += C + Math.min(d + sd, R + R - d - sd);
                            continue;
                        }
                        case 4: {
                            result += Math.abs(d - sd);
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }
}