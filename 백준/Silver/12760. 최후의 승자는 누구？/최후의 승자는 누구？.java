import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> cardList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            list.sort(Collections.reverseOrder());
            cardList.add(list);
        }

        int[] score = new int[N];

        for (int i = 0; i < M; i++) {
            int maxCard = 0;
            List<Integer> playerList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int card = cardList.get(j).get(i);
                if (maxCard < card) {
                    maxCard = card;
                    playerList = new ArrayList<>();
                    playerList.add(j);
                } else if (maxCard == card) {
                    playerList.add(j);
                }
            }

            for (int player : playerList) {
                score[player]++;
            }
        }

        int maxScore = 0;
        List<Integer> winnerList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (maxScore < score[i]) {
                maxScore = score[i];
                winnerList = new ArrayList<>();
                winnerList.add(i + 1);
            } else if (maxScore == score[i]) {
                winnerList.add(i + 1);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int winner : winnerList) {
            sb.append(winner).append(" ");
        }

        System.out.println(sb);
    }
}