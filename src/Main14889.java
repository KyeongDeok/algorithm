import java.util.*;
import java.io.*;

public class Main14889 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int HALF,N;
	static boolean [] sel;
	static int [][] map;
	static int min = Integer.MAX_VALUE;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		HALF = N/2;
		StringTokenizer stk;
		map = new int[N+1][N+1];
		sel = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = stoi(stk.nextToken());
			}
		}
		br.close();
		dfs(0,0);
		System.out.println(min);
	}
	public static void dfs(int cnt,int cur) {
		if(cnt == HALF) {
			min = Math.min(min,Math.abs(getSum(true,sel) - getSum(false,sel)));
			return;
		}
		for(int i=cur+1;i<=N;i++) {
			if(!sel[i]) {
				sel[i] = true;
				dfs(cnt+1,i);
				sel[i] = false;
			}
		}
	}
	public static int getSum(boolean team,boolean [] sel) {
		int sum=0;
		int [] S = new int[HALF+1];
		for(int i=1,j=1;i<=N;i++) {
			if((!team && sel[i]) || (team && !sel[i])) {
				S[j++] = i;
			}
		}
//		for(int s=1;s<=HALF;s++) {
//			System.out.println(team+":"+S[s]);
//		}
		for(int i=1;i<=HALF;i++) {
			for(int j=i+1;j<=HALF;j++) {
				sum += (map[S[i]][S[j]] + map[S[j]][S[i]]);
			}
		}
		return sum;
	}
}
