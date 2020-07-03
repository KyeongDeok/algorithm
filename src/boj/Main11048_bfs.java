package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11048_bfs {
	static int N,M;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int [][] dir = {{1,0},{1,1},{0,1}};
	static int [][] map;
	
	static class Node {
		int r,c,w;
		
		public Node (int r, int c,int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}
	
	public static void main(String [] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = stoi(stk.nextToken());
			M = stoi(stk.nextToken());
			map = new int[N+1][M+1];
			
			for(int i=1;i<=N;i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=1;j<=M;j++) {
					map[i][j] = stoi(stk.nextToken());
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int answer = bfs();
		System.out.println(answer);
	}
	
	public static int bfs() {
		Queue <Node> q = new LinkedList<>();
		q.offer(new Node(1,1,map[1][1]));
		int max = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int sr = n.r;
			int sc = n.c;
			int sw = n.w;

			int cr,cc;
			
			if(sw > max) {
				max = sw;
			}
			
			for(int i=0;i<3;i++) {
				cr = sr + dir[i][0];
				cc = sc + dir[i][1];
				
				if(check(cc,cr)) {
					q.offer(new Node(cr,cc,sw+map[cc][cr]));	
				}
			}
		}
		
		return max;
	}
	
	public static boolean check(int y,int x) {
		
		if(y<=0||y>N||x<=0||x>M) {
			return false;
		}
		
		return true;
	}
}
