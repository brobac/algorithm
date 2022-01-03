package boj;

import java.io.*;
import java.util.Arrays;

public class 음계 {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] a = bf.readLine().split(" ");
        int[] nums = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        boolean sorted = true;
        if(nums[0] == 1){
            for(int i = 1; i<= 7; i++) {
                if(nums[i]-nums[i-1] != 1) {
                    sorted = false;
                    break;
                }
            }
            if(sorted){
                System.out.print("ascending");
            }else{
                System.out.print("mixed");
            }
        }else if(nums[0] ==8){
            for(int i = 1; i<= 7; i++) {
                if(nums[i]-nums[i-1] != -1) {
                    sorted = false;
                    break;
                }
            }
            if(sorted){
                System.out.print("descending");
            }else{
                System.out.print("mixed");
            }
        }else{
            System.out.print("mixed");
        }
    }
}
