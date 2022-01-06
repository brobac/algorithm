package boj;

import java.util.Scanner;

public class 부녀회장이_될테야 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseNum = s.nextInt();
        for(int i = 0; i < caseNum; i++){
            int k = s.nextInt();
            int n = s.nextInt();
            int[][] p = new int[k+1][n];

            for(int j = 0; j < n; j++){
                p[0][j] = j+1;
            }
            for(int j = 1; j <= k; j++){
                for(int l = 0; l<n; l++){
                    for(int m = 0; m<=l; m++){
                        p[j][l] += p[j-1][m];
                    }
                }
            }
            System.out.println(p[k][n-1]);
        }
    }
}
