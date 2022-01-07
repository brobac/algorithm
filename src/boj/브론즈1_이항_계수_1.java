package boj;

import java.util.Scanner;

public class 브론즈1_이항_계수_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        if (n == k) {
            System.out.println(1);
        } else if (k == 1) {
            System.out.println(n);
        } else {
            int result = n;
            for (int i = 1; i < n - k; i++) {
                result *= n - i;
            }
            int d = 1;
            if (n - d > 0) {
                d = n -k;
                for (int i = 1; i < n - k - 1; i++) {
                    d *= n - k - i;
                }
            }
            System.out.println(result / d);
        }
    }
}
