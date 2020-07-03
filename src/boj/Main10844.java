package boj;

import java.util.*;
import java.io.*;

public class Main10844{
	static int mod = 1000000000;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] dp = new int[101][10];
		for(int i=1;i<10;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1]%mod;
				}else if(j == 9){
					dp[i][j] = dp[i-1][j-1]%mod;
				}else {
					dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1])%mod;
				}
			}
		}
		long answer=0;
		for(int k=0;k<10;k++) {
			answer += dp[n][k];
		}
		System.out.println(answer%mod);
	}
}