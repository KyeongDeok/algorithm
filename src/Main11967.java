import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11967 {
	
	static int N,M;
	static int [][] map;
	
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
	
	static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	static String makeKeyAndVal(String kv1,String kv2) {
		return kv1+" "+kv2;
	}
	
	static HashMap<String,List<String>> hm = new HashMap<>();
	public static void main(String [] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		try {
			stk = new StringTokenizer(br.readLine());
			N = stoi(stk.nextToken());
			M = stoi(stk.nextToken());
			map = new int[N+1][N+1];
			visited = new boolean[N+1][N+1];
			
			String key,val;
			for(int i=0;i<M;i++) {
				stk = new StringTokenizer(br.readLine());
				
				key = makeKeyAndVal(stk.nextToken(),stk.nextToken());
				val = makeKeyAndVal(stk.nextToken(),stk.nextToken());
				
				if(hm.containsKey(key)) {
					List <String> vals = hm.get(key);
					vals.add(val);
					hm.put(key,vals);
				}else {
					List <String> vals = new LinkedList<>();
					vals.add(val);
					hm.put(key,vals);
				}
			}
			
			bfs();
			System.out.println(countMap());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void turnOn(int x,int y) {
		String firstKey = makeKeyAndVal(String.valueOf(x), String.valueOf(y));
		
		if(!hm.containsKey(firstKey)) return;
		
		List<String> vals = hm.get(firstKey);
		
		StringTokenizer stk;
		
		for(String v : vals) {
			stk = new StringTokenizer(v);
			int xx =stoi(stk.nextToken());
			int yy = stoi(stk.nextToken());
			System.out.println(xx+":"+yy);
			map[yy][xx] = 1;
		}
		
		System.out.println(Arrays.deepToString(map));
	}
	
	public static int countMap() {
		int cnt = 0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				if(map[i][j] != 1) continue;
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public static void bfs() {
		Queue <Node> q = new LinkedList<>();
		q.offer(new Node(1,1));
		visited[1][1] = true;
		map[1][1] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int sx = n.x;
			int sy = n.y;
			
			int cx,cy;
			
			turnOn(sx,sy);
			
			for(int i=0;i<4;i++) {
				cy = sy+dir[i][0];
				cx = sx+dir[i][1];
				
				if(check(cx,cy)&&!visited[cy][cx]) {
					q.offer(new Node(cy,cx));
					visited[cy][cx] = true;
					System.out.println(cx+":"+cy);
				}
			}
		}
	}
	
	public static boolean check(int x,int y) {
		if(y<=0||y>N||x<=0||x>M||map[y][x] == 0) {
			return false;
		}
		return true;
	}
}
