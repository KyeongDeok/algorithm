import java.util.Scanner;

public class Main15486 {
	static class Counsel {
		int t, p;
		public Counsel(int t,int p) {
			this.t = t;
			this.p = p;
		}
	}
	/*
	 * 1. taken => ?
	 * 2. not taken => ?
	 */
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Counsel [] a = new Counsel [N+1];
		int [] dp = new int[N+2];
		int t,p;
		for(int i=1;i<=N;i++) {
			t = sc.nextInt();
			p = sc.nextInt();
			a[i] = new Counsel(t,p);
		}
		int ans=0;
		dp[1] = 0;
		for(int j=1;j<=N;j++) {
			if(j + a[j].t <= N+1) {
				if(dp[j + a[j].t] == 0) {
					
				}
				dp[j + a[j].t] = Math.max(dp[j + a[j].t], dp[j] + a[j].p);
				ans = Math.max(dp[j + a[j].t],ans);
				
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
