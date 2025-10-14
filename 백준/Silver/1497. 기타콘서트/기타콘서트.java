import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] guitarSongs = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 기타 이름은 필요 없으므로 버림
            String songInfo = st.nextToken();
            for (int j = 0; j < M; j++) {
                if (songInfo.charAt(j) == 'Y') {
                    // j번째 곡은 j번째 비트에 매핑 (더 직관적)
                    guitarSongs[i] |= (1L << j);
                }
            }
        }

        int maxSongCount = 0;
        int minGuitarCount = -1;

        // 1부터 (1 << N) - 1 까지 모든 기타 조합을 순회
        // i는 기타 조합을 나타내는 비트마스크
        for (int i = 1; i < (1 << N); i++) {

            int currentGuitarCount = Integer.bitCount(i); // 현재 조합에 사용된 기타 수
            long playableSongsMask = 0L;

            // 현재 조합(i)에 포함된 기타들을 확인
            for (int j = 0; j < N; j++) {
                // j번째 비트가 1이면, j번째 기타가 이 조합에 포함된 것
                if ((i & (1 << j)) != 0) {
                    playableSongsMask |= guitarSongs[j];
                }
            }

            int currentSongCount = Long.bitCount(playableSongsMask);

            if (currentSongCount > maxSongCount) {
                maxSongCount = currentSongCount;
                minGuitarCount = currentGuitarCount;
            } else if (currentSongCount == maxSongCount) {
                if (minGuitarCount > currentGuitarCount) {
                    minGuitarCount = currentGuitarCount;
                }
            }
        }

        // 연주 가능한 곡이 하나도 없는 경우
        if (maxSongCount == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minGuitarCount);
        }
    }
}