package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. bfs make cluster...
 * 2. calc
 * 3. check
 * 4. again..!
 */
public class Main16234 {
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
	static int N,L,R;
	static boolean [][] visited;
	static int [][] map;
	static int [][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = stoi(stk.nextToken());
		L = stoi(stk.nextToken());
		R = stoi(stk.nextToken());
		map = new int [N+1][N+1];
		visited = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = stoi(stk.nextToken());
			}
		}
		int cnt=0;
		int clu_num=0;
		while(true) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(visited[i][j]) continue;
						if(makeCluster(i,j)) {
							clu_num++;
							//System.out.println(Arrays.deepToString(map));
						}
				}
			}
			if(clu_num == 0) break;
			arrayFill(visited);
			cnt++;
			clu_num=0;
		}
		System.out.println(cnt);
	}
	public static void arrayFill(boolean [][] visited) {
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				visited[i][j] = false;
			}
		}
	}
	//move check
	public static boolean isPossible(int sy,int sx,int cy,int cx) {
		int p = Math.abs(map[sy][sx] - map[cy][cx]);
		if(L <= p && p <= R) {
			return true;
		}
		return false;
	}
	// first, make cluster and then do calc
	public static boolean makeCluster(int y,int x) {
		int cnt=1;
		int avg=0;
		int sum=map[y][x];
		ArrayList<Node> list = new ArrayList<>();
		list.add(new Node(y,x));
		Queue <Node> q = new LinkedList<>();
		q.offer(new Node(y,x));
		visited[y][x] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int sy = n.y;
			int sx = n.x;
			int cy,cx;
			for(int i=0;i<4;i++) {
				cy = sy + dir[i][0];
				cx = sx + dir[i][1];
				if(check(cy,cx) && isPossible(sy,sx,cy,cx) && !visited[cy][cx]) {
					visited[cy][cx] = true;
					sum+=map[cy][cx];
					cnt++;
					q.offer(new Node(cy,cx));
					list.add(new Node(cy,cx));
				}
			}
		}
		if(list.size() <= 1) {
			return false;
		}else {
			//calc
			avg = sum/cnt;
			for(Node n : list) {
				map[n.y][n.x] = avg;
			}
			return true;
		}
	}
	public static boolean check(int y,int x) {
		if(y <= 0 || y > N || x <= 0 || x > N) {
			return false;
		}
		return true;
	}
}
