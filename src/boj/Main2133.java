package boj;

import java.util.Scanner;

//2 -> 3
//3 -> 0
//4 -> 3 * 3 +2
//5 -> 0
//6 -> 27 + 6 + 6 + 2 = 4
//7 -> 0
//8 ->  3 * dp[6] + 2 * dp[]  3 * 41 123 6 + 2
// 
//dp[2]^i/2 + 4 * dp[i-2] + 2;
//dp[2*n] = dp[n]^ + 2;

public class Main2133 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int ans = 0;
		if(N%2 == 0) {
			int [] dp = new int[N+1];
			dp[2] = 3;
			dp[0] = 1;
			for(int i=4;i<=N;i+=2) {
				for(int j=2;j<=i;j+=2) {
					int s = j==2 ? 3 : 2;
					dp[i] += s*dp[i-j];
				}
			}
			ans = dp[N];
		}
		System.out.println(ans);
	}
}