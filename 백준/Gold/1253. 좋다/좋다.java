import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                list.add(n);
                map.put(n, 1);

            }
        }
        int result = 0;
        Collections.sort(list);

        good:
        for (int targetIdx = 0; targetIdx < list.size(); targetIdx++) {
            int leftIdx = 0;
            int rightIdx = list.size() - 1;
            int target = list.get(targetIdx);
            while (leftIdx <= rightIdx) {

                int left = list.get(leftIdx);
                int right = list.get(rightIdx);

                if (left == right && map.get(left) < 2) {
                    break;
                }
                if (left == right && target == left && map.get(left) < 3) {
                    break;
                }

                if (left == target && map.get(left) == 1) {
                    leftIdx++;
                    continue;
                }
                if (right == target && map.get(right) == 1) {
                    rightIdx--;
                    continue;
                }

                int sum = left + right;

                if (sum < target) {
                    leftIdx++;
                } else if (target < sum) {
                    rightIdx--;
                } else {
                    result += map.get(target);
                    continue good;
                }
            }

        }

        System.out.println(result);
    }
}