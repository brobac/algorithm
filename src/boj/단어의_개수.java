package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sa = s.split(" ");
        int count = 0;
        for( String ss : sa){
            if(ss.length() >= 1) count++;
        }
        System.out.print(count);
    }
}
