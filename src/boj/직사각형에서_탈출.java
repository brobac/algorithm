package boj;

import java.util.Scanner;

public class 직사각형에서_탈출 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int w = s.nextInt();
        int h = s.nextInt();
        int min = w-x;
        if(h-y < min) min = h-y;
        if(x < min) min = x;
        if(y < min) min = y;
        System.out.print(min);
    }
}
