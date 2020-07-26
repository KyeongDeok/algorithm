
//https://www.acmicpc.net/submit/11057/18854843
//오르막수...

import java.io.*;
import java.util.*;

class Groom43171 {
	static int min = Integer.MAX_VALUE;
    static int N;
    static int [] dp;
	static int stoi(String s){
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		dp = new int[N+1];
		
		for(int i=1;i<=N;i++){
			dp[i] = stoi(stk.nextToken());
        }

        if(isAsc(dp)){
            System.out.println(0);
        }else{
            Stack <Integer> st = new Stack<>();
            dfs(0,0,st);
            System.out.println(min);
        }
    }
    
	public static void dfs(int index, int cnt, Stack <Integer> st){
		if(N <= index){
			if(cnt < min){
				min = cnt;
			}
			return;
        }
        
        if(st.isEmpty() || st.peek() < dp[index]){
            dfs(index + 1, cnt + 1, st);
            
            st.push(dp[index]);
            dfs(index + 1, cnt, st);
            st.pop();
        }else{
            dfs(index + 1, cnt+1, st);
        }
    }
    static boolean isAsc(int [] dp){
        int len = dp.length;
        for(int i=0;i<len-1;i++){
            if(dp[i] > dp[i+1])
                return false;
        }

        return true;
    }
}
