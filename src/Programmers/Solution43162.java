package Programmers;

import java.util.*;

class Solution43162 {
    static boolean [] visited;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(n,i,computers);
                cnt++;
            }
        }
        return cnt;
    }
    public static void bfs(int n,int point, int [][] computers){
        Queue <Integer> q = new LinkedList<>();
        q.offer(point);

        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0;i<n;i++){
                if(computers[p][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}