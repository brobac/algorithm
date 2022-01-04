package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] a = bf.readLine().split(" ");
        int[] nums = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for( int n : nums){
            sum += (n * n);
        }
        System.out.print(sum%10);
    }
}
