import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] used = new boolean[N + 1];
        ArrayList<int[]> roomList = new ArrayList<>();
        roomList.add(new int[]{});
        StringBuilder sb = new StringBuilder();
        query:
        for (; 0 < Q; Q--) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            switch (op) {
                case "new": {
                    int X = Integer.parseInt(st.nextToken());
                    int Y = Integer.parseInt(st.nextToken());
                    int l = 1;
                    int count = 0;
                    while (l + Y - 1 <= N) {
                        for (int r = l; r <= N; r++) {
                            if (used[r]) {
                                count = 0;
                                l = r + 1;
                                break;
                            } else {
                                count++;
                                if (count == Y) {
                                    roomList.add(new int[]{X, l, r});
                                    for (int i = l; i <= r; i++) {
                                        used[i] = true;
                                    }
                                    sb.append(l).append(" ").append(r).append("\n");
                                    continue query;
                                }
                            }
                        }
                    }
                    sb.append("REJECTED\n");
                    break;
                }
                case "in": {
                    int A = Integer.parseInt(st.nextToken());
                    int B = Integer.parseInt(st.nextToken());
                    roomList.get(A)[0] += B;
                    break;
                }
                case "out": {
                    int A = Integer.parseInt(st.nextToken());
                    int B = Integer.parseInt(st.nextToken());
                    roomList.get(A)[0] -= B;


                    if (roomList.get(A)[0] == 0) {
                        for (int i = roomList.get(A)[1]; i <= roomList.get(A)[2]; i++) {
                            used[i] = false;
                        }
                        sb.append("CLEAN ").append(roomList.get(A)[1]).append(" ").append(roomList.get(A)[2]).append("\n");
                    }

                    break;
                }
            }
        }
        System.out.println(sb);
    }
}