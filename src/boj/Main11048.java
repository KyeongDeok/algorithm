package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11048 {
	
	static int N,M;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int getMax(int a,int b,int c) {
		return Math.max(c,Math.max(a,b));
	}
	public static void main(String [] args) {
		int [][] map = new int [1001][1001];
		int [][] dp = new int[1001][1001];
		char [] open = {'{','('};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		try {
			stk = new StringTokenizer(br.readLine());
			N = stoi(stk.nextToken());
			M = stoi(stk.nextToken());
			
			for(int i=1;i<=N;i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=1;j<=M;j++) {
					map[i][j] = stoi(stk.nextToken());
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					dp[i][j] = map[i][j] + getMax(dp[i-1][j],dp[i-1][j-1],dp[i][j-1]);
				}
			}
			
			System.out.println(dp[N][M]);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println();
	}
}
