package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class ACM호텔 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i<a; i++){
            int h = s.nextInt();
            int w = s.nextInt();
            int n = s.nextInt();

            int resultH = (n % h) * 100;
            int resultW = (n / h) + 1;
            if((n % h) == 0) {
                resultH = h * 100;
                resultW--;
            }
            al.add(resultH+resultW);
        }
        for(int i =0; i <a-1; i++){
            System.out.println(al.get(i));
        }
        System.out.print(al.get(a-1));
    }
}
