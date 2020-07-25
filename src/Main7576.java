import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
	static int N,M;
	static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [][] map;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Node{
		int y,x,t;
		public Node(int y,int x,int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		M = stoi(stk.nextToken());
		N = stoi(stk.nextToken());
		map = new int[N][M];
		Queue <Node> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = stoi(stk.nextToken());
				if(map[i][j] == 1) {
					q.offer(new Node(i,j,0));
				}
			}
		}
		int max = bfs(q);
		if(isAllClear()) {
			System.out.println(max);
		}else {
			System.out.println(-1);
		}
	
	}
	public static int bfs(Queue <Node> q) {
		int max = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int sy = n.y;
			int sx = n.x;
			int st = n.t;
			max = Math.max(max,st);
			int cy,cx;
			for(int i=0;i<4;i++) {
				cy = sy + dir[i][0];
				cx = sx + dir[i][1];
				if(check(cy,cx) && map[cy][cx] == 0) {
					map[cy][cx] = 1;
					q.offer(new Node(cy,cx,st+1));
				}
			}
		}
		return max;
	}
	public static boolean check(int y,int x) {
		if(y < 0 || y >= N || x < 0 || x >= M) {
			return false;
		}
		return true;
	}
	public static boolean isAllClear() {
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
