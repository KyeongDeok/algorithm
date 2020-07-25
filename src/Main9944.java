import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9944 {
	static int N,M;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Node {
		int y,x;
		public Node(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
	static char [] comm = {'U','D','R','L'};
	static int min = Integer.MAX_VALUE;
	static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int [][] map;
	public static void main(String [] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = stoi(stk.nextToken());
		M = stoi(stk.nextToken());
		map = new int[N][M];
		char c;
		String s;
		//map init
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<M;j++) {
				switch(s.charAt(j)) {
				case '*':
					map[i][j] = -1;
					break;
				case '.':
					map[i][j] = 0;
					break;
				}
			}
		}
		//dfs
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(i,j,0);
					map[i][j] = 0;
				}
			}
		}
		System.out.println(min);
	}
	public static void dfs(int y,int x,int cnt) {
		System.out.println("test");
		if(isComp()) {
			min = Math.min(min, cnt);
			return;
		}
		for(int i=0;i<4;i++) {
			int cy = y + dir[i][0];
			int cx = x + dir[i][1];
			if(check(cy,cx) && map[cy][cx] == 0) {
				map[cy][cx] = 1;
				dfs(cy,cx,cnt+1);
				map[cy][cx] = 0;
			}
		}
	}
	public static boolean check(int y,int x) {
		if(y < 0 || y >= N || x < 0 || x <= M) {
			return false;
		}
		return true;
	}
	public static boolean isComp() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}