package boj;
import java.util.*;
import java.io.*;
/*
 * 1. labeling을 한다.
 * 2. 완탐을 통해 최소 거리 다리를 찾는다. (priorityQueue에 다넣고 확인...!)
 * 3. union find로 중복 다리인지 아닌지 찾는다.(MST)
 */
public class Boj {
	static class Node{
		int y,x;
		public Node(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
	static class Edge implements Comparable <Edge> {
		int e1,e2,w;
		public Edge(int e1,int e2,int w) {
			this.e1 = e1;
			this.e2 = e2;
			this.w = w;
		}
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}
	static PriorityQueue <Edge> pq = new PriorityQueue<>();
	static int [] root;
	static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N,M;
	static int [][] map;
	static boolean [][] visited;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = stoi(stk.nextToken());
		M = stoi(stk.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		//init
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = stoi(stk.nextToken());
			}
		}
		//labeling
		int cnt=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					labeling(i,j,cnt);
					cnt++;
				}
			}
		}
		rootInit(cnt);
		//brute-force
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != 0) {
					findEdge(i,j);
				}
			}
		}
		int answer = 0;
		Iterator <Edge> itr = pq.iterator();
		while(itr.hasNext()) {
			Edge eg = pq.poll();
			//1이하면 continue;
			if(eg.w <= 1) continue;
			if(find(eg.e1) != find(eg.e2)) {
				union(eg.e1,eg.e2);
				answer += eg.w;
			}
		}
//		for(int r : root) {
//			System.out.print(r+" ");
//		}
		//모든 섬이 연결되었는지 확인.
		if(!isAllRootSame() || answer == 0 ) answer = -1;
		System.out.println(answer);
	}
	public static boolean isAllRootSame() {
		int len = root.length;
		for(int i=1;i<len-1;i++) {
			if(find(i) != find(i+1)) {
				return false;
			}
		}
		return true;
	}
	public static void rootInit(int cnt) {
		root = new int[cnt];
		for(int i=1;i<cnt;i++) {
			root[i] = i;
		}
	}
	public static void union(int x,int y) {
		x = find(x);
		y = find(y);
		root[y] = x;
	}
	public static int find(int x) {
		if(root[x] == x) {
			return x;
		}else {
			return root[x] = find(root[x]);
		}
	}
	public static void findEdge(int y,int x) {
		for(int k=0;k<4;k++) {
			int cnt = 0;
			int cy = y;
			int cx = x;
			while(true) {
				cy += dir[k][0];
				cx += dir[k][1]; 
				if(!check(cy,cx) || map[y][x] == map[cy][cx]) {
					break;
				}
				if(cnt != 0 && map[y][x] != map[cy][cx] && map[cy][cx] != 0 ) {
					pq.offer(new Edge(map[y][x],map[cy][cx],cnt));
					break;
				}
				cnt+=1;
			}
		}
	}
	public static void labeling (int i,int j,int cnt) {
		Queue <Node> q = new LinkedList<>();
		q.offer(new Node(i,j));
		visited[i][j] = true;
		map[i][j] = cnt;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int sx = node.x,sy = node.y;
			int cx,cy;
			for(int k=0;k<4;k++) {
				cy = sy + dir[k][0];
				cx = sx + dir[k][1];
				if(check(cy,cx) && map[cy][cx] != 0 && !visited[cy][cx]) {
					q.offer(new Node(cy,cx));
					visited[cy][cx] = true;
					map[cy][cx] = cnt;
				}
			}
		}
	}
	public static boolean check(int y,int x) {
		if(y < 0 || y >= N || x < 0 || x >= M) {
			return false;
		}else {
			return true;	
		}
	}
}
