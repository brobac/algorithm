package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(nums[0]+nums[1]+nums[2] == 0) break;
            Arrays.sort(nums);
            if(nums[2] * nums[2] == (nums[0] * nums[0]+nums[1] * nums[1])) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
