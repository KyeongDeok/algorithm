package boj;

import java.util.*;
import java.io.*;

class Main1938 {
	/*
	 * 1. 3x3 회전 가능한지 체크
	 * 2. bfs...
	 */
	static int [][] turnDir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	static class Wood{
		int y,x,dir,cnt;
		public Wood(int y,int x,int dir,int cnt) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	static boolean [][][] visited;
	static int answer = Integer.MAX_VALUE;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int [N][N];
		visited = new boolean [N][N][2];
		int by=0,bx=0;
		int ey=0,ex=0;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				char c = str.charAt(j);
				if(c == 'B') {
					by = i;
					bx = j;
					map[i][j] = 2;
				}else if(c == 'E') {
					ey = i;
					ex = j;
					map[i][j] = 3;
				}else if(c == '1') {
					map[i][j] = 1;
				}else if (c == '0') {
					map[i][j] = 0;
				}
			}
		}
		//System.out.println("bx:"+bx+" by:"+by);
		bfs(by,bx,ey,ex,map);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(answer);
		}
	}
	public static void bfs(int by,int bx,int ey,int ex,int [][] map) {
		Queue <Wood> q = new LinkedList<>();
		String command = "UDLRT";
		Wood goal = getMidWood(ey,ex,map);
		//System.out.println(goal.x+" "+goal.y);
		Wood sw = getMidWood(by,bx,map);
		visited[sw.y][sw.x][sw.dir] = true;
		q.offer(sw);
		while(!q.isEmpty()) {
			Wood w = q.poll();
			int wx = w.x;
			int wy = w.y;
			int wdir = w.dir;
			int wcnt = w.cnt;
			if(wx == goal.x && wy == goal.y && wdir == goal.dir) {
				answer = Math.min(answer, wcnt);
			}
			for(int i=0;i<command.length();i++) {
				switch(command.charAt(i)) {
				case 'U':
					if(isUp(wy,wx,wdir,map)) {
						if(!visited[wy-1][wx][wdir]) {
							visited[wy-1][wx][wdir] = true;
							q.offer(new Wood(wy-1,wx,wdir,wcnt+1));
						}
					}
				case 'D':
					if(isDown(wy,wx,wdir,map)) {
						if(!visited[wy+1][wx][wdir]) {
							visited[wy+1][wx][wdir] = true;
							q.offer(new Wood(wy+1,wx,wdir,wcnt+1));
						}
					}
				case 'L':
					if(isLeft(wy,wx,wdir,map)) {
						if(!visited[wy][wx-1][wdir]) {
							visited[wy][wx-1][wdir] = true;
							q.offer(new Wood(wy,wx-1,wdir,wcnt+1));
						}
					}
				case 'R':
					if(isRight(wy,wx,wdir,map)) {
						if(!visited[wy][wx+1][wdir]) {
							visited[wy][wx+1][wdir] = true;
							q.offer(new Wood(wy,wx+1,wdir,wcnt+1));	
						}
					}
				case 'T':
					if(isTurn(wy,wx,map)) {
						if(wdir == 0 && !visited[wy][wx][1]) {
							visited[wy][wx][1] = true;
							q.offer(new Wood(wy,wx,1,wcnt+1));
						}else if(wdir == 1 && !visited[wy][wx][0]){
							visited[wy][wx][0] = true;
							q.offer(new Wood(wy,wx,0,wcnt+1));
						}
					}
				}
			}
		}
	}
	public static boolean isUp(int y,int x,int dir,int [][] map) {
		int cy,cx;
		//세로일때,
		if(dir == 0) {
			if(!check(y-2,x,map) || map[y-2][x] == 1) {
				return false;
			}
		}
		//가로일때,
		else {
			for(int i=0;i<3;i++) {
				cy = y + turnDir[i][0];
				cx = x + turnDir[i][1];
				if(!check(cy,cx,map) || map[cy][cx] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isDown(int y,int x,int dir,int [][] map) {
		int cy,cx;
		//세로일때,
		if(dir == 0) {
			if(!check(y+2,x,map) || map[y+2][x] == 1) {
				return false;
			}
		}
		//가로일때,
		else {
			for(int i=3;i>0;i--) {
				cy = y + turnDir[turnDir.length - i][0];
				cx = x + turnDir[turnDir.length - i][1];
				if(!check(cy,cx,map) || map[cy][cx] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isRight(int y,int x,int dir,int [][] map) {
		int cy,cx;
		//가로일때,
		if(dir == 1) {
			if(!check(y,x+2,map) || map[y][x+2] == 1) {
				return false;
			}
		}
		//세로일때,
		else {
			int [][] moveDir = {{-1,1},{0,1},{1,1}};
			for(int i=0;i<3;i++) {
				cy = y + moveDir[i][0];
				cx = x + moveDir[i][1];
				if(!check(cy,cx,map) || map[cy][cx] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isLeft(int y,int x,int dir,int [][] map) {
		int cy,cx;
		//가로일때,
		if(dir == 1) {
			if(x-2 < 0 || map[y][x-2] == 1) {
				return false;
			}
		}
		//세로일때,
		else {
			int [][] moveDir = {{-1,-1},{0,-1},{1,-1}};
			for(int i=0;i<3;i++) {
				cy = y + moveDir[i][0];
				cx = x + moveDir[i][1];
				if(!check(cy,cx,map) || map[cy][cx] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isTurn(int y,int x,int [][] map) {
		int cy,cx;
		for(int i=0;i<8;i++) {
			cy = y + turnDir[i][0];
			cx = x + turnDir[i][1];
			if(!check(cy,cx,map) || map[cy][cx] == 1) {
				return false;
			}
		}
		return true;
	}
	public static boolean check(int y,int x,int [][] map) {
		if(y < 0 || y >= map.length || x < 0 || x >= map.length) {
			return false;
		}
		return true;
	}
	public static Wood getMidWood(int y,int x,int [][] map) {
		int dir=0;
		int yy=y;
		int xx=x;
		if(check(y-1,x,map) && (map[y-1][x] == 2 || map[y-1][x] == 3)) {
			dir = 0;
			yy-=1;
		}else if(check(y,x-1,map) && (map[y][x-1] == 2 || map[y][x-1] == 3)){
			dir = 1;
			xx-=1;
		}
		//System.out.println(yy+" "+xx);
		Wood w = new Wood(yy,xx,dir,0);
		return w;
	}
}