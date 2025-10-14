import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] able;
    static int maxSong = 0;
    static int minGuitar = 11;
    static long target;

    static int a = 0;


    static void solution(int cnt, int start, long v) {
        if (maxSong < Long.bitCount(v)) {
            maxSong = Long.bitCount(v);
            minGuitar = cnt;
        } else if (maxSong == Long.bitCount(v) && cnt < minGuitar) {
            minGuitar = cnt;
        }

        if (cnt == N) return;

        for (int i = start; i < N; i++) {
            solution(cnt + 1, i + 1, v | able[i]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        target = (long) Math.pow(2, M) - 1;
        able = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            char[] song = st.nextToken().toCharArray();

            for (int j = 0; j < M; j++) {
                if (song[j] == 'Y') {
                    able[i] |= (1L << (M - 1 - j));
                }
            }
        }


        solution(0, 0, 0);


        System.out.println(maxSong == 0 ? -1 : minGuitar);
    }
}