import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int S;
    static char[] num;
    static char[][] lcd;

    static boolean[][] on = {
            {true, true, true, false, true, true, true}, // 0
            {false, false, true, false, false, true, false}, // 1
            {true, false, true, true, true, false, true}, // 2
            {true, false, true, true, false, true, true}, // 3
            {false, true, true, true, false, true, false}, // 4
            {true, true, false, true, false, true, true}, // 5
            {true, true, false, true, true, true, true}, // 6
            {true, false, true, false, false, true, false}, // 7
            {true, true, true, true, true, true, true}, // 8
            {true, true, true, true, false, true, true}, // 9
    };

    static void paint(int order, int number) {
        int l = order * (S + 2) + order;
        int r = l + S + 1;

        if (on[number][0]) {
            for (int i = 1; i <= S; i++) {
                lcd[0][l + i] = '-';
            }
        }
        if (on[number][1]) {
            for (int i = 1; i <= S; i++) {
                lcd[i][l] = '|';
            }
        }
        if (on[number][2]) {
            for (int i = 1; i <= S; i++) {
                lcd[i][r] = '|';
            }
        }
        if (on[number][3]) {
            for (int i = 1; i <= S; i++) {
                lcd[S + 1][l + i] = '-';
            }
        }
        if (on[number][4]) {
            for (int i = 1; i <= S; i++) {
                lcd[S + 1 + i][l] = '|';
            }
        }
        if (on[number][5]) {
            for (int i = 1; i <= S; i++) {
                lcd[S + 1 + i][r] = '|';
            }
        }
        if (on[number][6]) {
            for (int i = 1; i <= S; i++) {
                lcd[2 * S + 2][l + i] = '-';
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        num = st.nextToken().toCharArray();

        int ROW = 2 * S + 3;
        int COL = (S + 2) * num.length + num.length - 1;
        lcd = new char[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            Arrays.fill(lcd[r], ' ');
        }

        for (int i = 0; i < num.length; i++) {
            paint(i, num[i] - '0');
        }

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                System.out.print(lcd[r][c]);
            }
            System.out.println();
        }


    }
}