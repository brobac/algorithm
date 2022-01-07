package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class 브론즈1_팰린드롬수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Boolean> isPalindromes = new ArrayList<>();
        while (true){
            String s = scan.next();
            if(s.equals("0")) break;

            boolean isPalindrome = true;
            for(int i = 0; i <= s.length()/2; i++){
                if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            isPalindromes.add(isPalindrome);
        }
        for(Boolean b : isPalindromes){
            if(b) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
