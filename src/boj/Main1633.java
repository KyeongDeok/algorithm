package boj;

import java.util.Scanner;

public class Main1633 {
	static int N=1;
	static int [][] a = new int[1001][2];
	static int [][][] dp = new int[1001][16][16];
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			a[N][0] = sc.nextInt();
			a[N][1] = sc.nextInt();
			dp[N][1][0] = a[N][0];
			dp[N][0][1] = a[N][1];
			N++;
		}
		sc.close();
		for(int i=1;i<N;i++) {
			for(int b=0;b<=15;b++) {
				for(int w=0;w<=15;w++) {
					dp[i][b][w] = Math.max(dp[i][b][w],dp[i-1][b][w]);
					if(b>=1)
						dp[i][b][w] = Math.max(dp[i][b][w],dp[i-1][b-1][w] + a[i][0]);
					if(w>=1)
						dp[i][b][w] = Math.max(dp[i][b][w],dp[i-1][b][w-1] + a[i][1]);
				}
			}
		}
		System.out.println(dp[N-1][15][15]);
	}
}