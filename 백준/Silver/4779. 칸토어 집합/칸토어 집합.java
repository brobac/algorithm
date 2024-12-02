import java.io.*;

public class Main {
    static String[] res = new String[13];

    static {
        res[0] = "-";
        for (int i = 1; i <= 12; i++) {
            StringBuilder sb = new StringBuilder();
            int len = (int) Math.pow(3, i - 1);
            sb.append(res[i - 1]);
            for (int j = 0; j < len; j++) {
                sb.append(" ");
            }
            sb.append(res[i - 1]);
            res[i] = sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            bw.write(res[Integer.parseInt(input)]);
            bw.newLine();
        }
        bw.flush();
    }
}