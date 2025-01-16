import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] segmentStrings = {
                "0111111",
                "0001010",
                "1011101",
                "1001111",
                "1101010",
                "1100111",
                "1110111",
                "0001011",
                "1111111",
                "1101011"
        };

        int[] segments = new int[10];
        for (int i = 0; i < 10; i++) {
            segments[i] = Integer.parseInt(segmentStrings[i], 2);
        }

        while (true) {
            String input = br.readLine();
            if (input.equals("BYE")) break;
            sb.append(input);
            String[] nums = input.substring(0, input.length() - 1).split("\\+");

            int result = 0;

            for (String s : nums) {
                int temp = 0;
                for (int i = 0; i < s.length(); i += 3) {
                    temp *= 10;
                    int num = Integer.parseInt(s.substring(i, i + 3));
                    for (int j = 0; j < 10; j++) {
                        if (num == segments[j]) {
                            temp += j;
                            break;
                        }
                    }
                }
                result += temp;
            }

            for (char c : Integer.toString(result).toCharArray()) {
                int num = segments[c - '0'];
                if (num < 100) {
                    sb.append("0");
                }
                sb.append(num);
            }

            sb.append("\n");


        }

        System.out.println(sb);
    }
}