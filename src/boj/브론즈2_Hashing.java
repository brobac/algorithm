package boj;

import java.util.Scanner;

public class 브론즈2_Hashing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        String str = s.next();
        long sum = 0;
        for(int i = 0; i<l; i++){
            int n = 1;
            for(int j = 0; j < i; j++){
                n *= 31 % 1234567891;
            }
            sum += (long) (str.charAt(i) - 'a' + 1) * n;
            sum %= 1234567891;
        }
        System.out.println(sum);
    }
}
