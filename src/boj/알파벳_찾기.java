package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[] charIndex = new Integer[26];
        String s = bf.readLine();
        Arrays.fill(charIndex, -1);
        for(int i = 0; i<s.length(); i++){
            if( 'a' <= s.charAt(i) && s.charAt(i) <= 'z' && charIndex[s.charAt(i) - 'a'] == -1){
                charIndex[s.charAt(i) - 'a'] = i;
            }
        }
        System.out.print(charIndex[0]);
        for(int i = 1; i<charIndex.length; i++){
            System.out.print(" "+charIndex[i]);
        }
    }
}
