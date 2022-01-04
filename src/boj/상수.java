package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] a = bf.readLine().split(" ");
        int[] nums = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        int[] reverseNums = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<3; j++){
                if(nums[i] > 9){
                    reverseNums[i] += nums[i]%10;
                    reverseNums[i] *= 10;
                    nums[i] /= 10;
                }else {
                    reverseNums[i] += nums[i];
                }
            }
        }
        if(reverseNums[0] < reverseNums[1]){
            System.out.print(reverseNums[1]);
        }else{
            System.out.print(reverseNums[0]);
        }
    }
}
