import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean np(int[] arr) {
        int N = arr.length;

        int top = N - 1;
        while (0 < top && arr[top] <= arr[top - 1]) {
            top--;
        }
        if (top == 0) return false;

        int right = N - 1;
        while (arr[top - 1] >= arr[right]) {
            right--;
        }
        swap(arr, top - 1, right);

        right = N - 1;
        while (top < right) {
            swap(arr, top++, right--);
        }
        return true;

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = input[i] - '0';
        }


        if (np(nums)) {
            StringBuilder sb = new StringBuilder();
            for (int v : nums) {
                sb.append(v);
            }
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }
}