import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(visited[i]) continue;
            answer++;
            Queue<Integer> q = new ArrayDeque();
            visited[i] = true;
            q.offer(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j = 0; j<n; j++){
                    if(cur == j || visited[j] || computers[cur][j] == 0) continue;
                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
        return answer;
    }
}