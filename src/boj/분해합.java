package boj;

import java.util.Scanner;

public class 분해합 {
    public static void main(String[] args) {
        int[] a = new int[1000054];
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        for(int i =1; i<=1000000; i++){
            int sum = i;
            int n = i;
            while(n > 0){
                sum += n % 10;
                n /= 10;
            }
            if(a[sum] == 0) a[sum] = i;
        }
        System.out.print(a[input]);
    }
}
