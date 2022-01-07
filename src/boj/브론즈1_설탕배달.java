package boj;

import java.util.Scanner;

public class 브론즈1_설탕배달 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            boolean b = false;
            int threeCount = 1;
            int tmp = n;
            while (tmp >= 8) {
                if ((tmp - 3) % 5 == 0) {
                    b = true;
                    break;
                }
                tmp -= 3;
                threeCount++;
            }
            if (n % 5 == 0) {
                System.out.println(n / 5);
            } else if (b) {
                System.out.println(threeCount + (n - 3 * threeCount) / 5);
            } else if (n % 3 == 0) {
                System.out.println(n / 3);
            } else {
                System.out.println(-1);
            }
        }
}
