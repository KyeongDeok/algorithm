package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600{
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int W,H,K;
	static boolean [][][] visited;
	static int [][] map;
	static int [][] horse = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
	static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static class Node{
		int y,x,t,h;
		public Node(int y,int x,int t,int h) {
			this.y = y;
			this.x = x;
			this.t = t;
			this.h = h;
		}
	}
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = stoi(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		W = stoi(stk.nextToken());
		H = stoi(stk.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i=0;i<H;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j] = stoi(stk.nextToken());
			}
		}
		System.out.println(bfs());
	}
	public static int bfs() {
		int min = Integer.MAX_VALUE;
		Queue <Node> q = new LinkedList<>();
		q.offer(new Node(0,0,0,0));
		while(!q.isEmpty()) {
			Node n = q.poll();
			int sy = n.y;
			int sx = n.x;
			int st = n.t;
			int sh = n.h;
			if(sy == H-1 && sx == W-1) {
				min = Math.min(min,st);
			}
			int cy,cx;
			for(int i=0;i<4;i++) {
				cy = sy + dir[i][0];
				cx = sx + dir[i][1];
				if(check(cy,cx) && map[cy][cx] != 1 && !visited[cy][cx][sh]) {
					visited[cy][cx][sh] = true;
					q.offer(new Node(cy,cx,st+1,sh));
				}
			}
			if(sh < K) {
				for(int i=0;i<8;i++) {
					cy = sy + horse[i][0];
					cx = sx + horse[i][1];
					if(check(cy,cx) && map[cy][cx] != 1 && !visited[cy][cx][sh+1]) {
						visited[cy][cx][sh+1] = true;
						q.offer(new Node(cy,cx,st+1,sh+1));
					}
				}
			}
		}
		if(min == Integer.MAX_VALUE) {
			return -1;
		}else {
			return min;
		}
	}
	public static boolean check(int y,int x) {
		if(y < 0 || y >= H || x < 0 || x >= W) {
			return false;
		}
		return true;
	}
}
