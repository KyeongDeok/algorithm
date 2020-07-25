import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main18428 {
	static int stoi (String s) {
		return Integer.parseInt(s);
	}
	static class Teacher{
		int y,x;
		public Teacher(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int ans = 0;
	static int [][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
	static int [][] map;
	static ArrayList <Teacher> t = new ArrayList<>();
	static int N;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = stoi(br.readLine());
		map = new int[N][N];
		char c;
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				c = stk.nextToken().charAt(0);
				if(c == 'X') {
					map[i][j] = 0;
				}else if(c == 'S') {
					map[i][j] = 1;
				}else if(c == 'T') {
					map[i][j] = 2;
					t.add(new Teacher(i,j));
				}
			}
		}
		dfs(0,0,0);
		if(ans == 0) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		br.close();
	}
	public static void dfs(int sely,int selx,int lev) {
		if(lev == 3) {
			if(findS()) {
//				System.out.println("test");
				ans++;
			}
//			System.out.println(Arrays.deepToString(map));
			return;
		}
		for(int i=sely;i<N;i++) {
			for(int j=selx;j<N;j++) {
				if(map[i][j] == 0) {
					map[i][j] = -1;
					dfs(i,j+1,lev+1);
					map[i][j] = 0;
				}
			}
			selx = 0;
		}
	}
	public static boolean check(int y,int x) {
		if(y < 0 || y >=N || x < 0 || x >= N) {
			return false;
		}
		return true;
	}
	public static boolean findS() {
		Iterator <Teacher> itr = t.iterator();
		while(itr.hasNext()) {
			Teacher t = itr.next();
			for(int i=0;i<4;i++) {
				int ty = t.y;
				int tx = t.x;
				while(check(ty,tx)) {
					if(map[ty][tx] == 1) {
//						System.out.println("test");
						return false;
					}
					else if(map[ty][tx] == -1) {
						break;
					}else {
						ty += dir[i][0];
						tx += dir[i][1];
					}
				}
			}
		}
		return true;
	}
}
