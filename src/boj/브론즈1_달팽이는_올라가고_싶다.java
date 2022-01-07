package boj;

import java.util.Scanner;

public class 브론즈1_달팽이는_올라가고_싶다 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int v = s.nextInt();
        System.out.print((int)Math.ceil((double)(v-b)/(a-b)));
    }
}
