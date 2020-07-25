import java.util.*;
import java.io.*;
public class Main15686 {
	static int N,M;
	static int [][] map;
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Chicken implements Comparable<Chicken>{
		int r,c,dist;
		public Chicken(int r,int c,int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		public int compareTo(Chicken cc) {
			return this.dist - cc.dist;
		}
	}
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = stoi(stk.nextToken());
		M = stoi(stk.nextToken());
		map = new int[N+1][N+1];
		ArrayList<Chicken> c = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = stoi(stk.nextToken());
				if(map[i][j] == 2) {
					c.add(new Chicken(i,j,0));
				}
			}
		}
		PriorityQueue <Chicken> pq = new PriorityQueue<>();
		//치킨집 선택하기.
		selChicken(c,pq);
		ArrayList <Chicken> list = new ArrayList<>();
		for(int k=0;k < M;k++) {
			Chicken ch = pq.poll();
			list.add(ch);
			System.out.println(ch.dist+":"+ch.r+":"+ch.c);
		}
		//남은 치킨집 없애기
		Iterator <Chicken> itr = pq.iterator();
		while(itr.hasNext()) {
			Chicken chicken = itr.next();
			map[chicken.r][chicken.c] = 0;
		}
		//각 집과 치킨집간의 거리계산하기
		System.out.println(calcDist(list));
	}
	public static int calcDist(ArrayList <Chicken> list) {
		Chicken chicken;
		Iterator <Chicken> itr;
		int sum=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(map[i][j] != 1) continue;
				int min=Integer.MAX_VALUE;
				itr = list.iterator();
				while(itr.hasNext()) {
					chicken = itr.next();
					min = Math.min(min,calc(chicken.r,chicken.c,i,j));
				}
				System.out.println(min);
				sum+=min;
			}
		}
		return sum;
	}
	public static void selChicken(ArrayList <Chicken> c,PriorityQueue <Chicken> pq) {
		int sum=0;
		Iterator <Chicken> itr = c.iterator();
		while(itr.hasNext()) {
			Chicken chicken = itr.next();
			int cr=chicken.r,cc = chicken.c;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j] == 1) {
						sum+=calc(cr,cc,i,j);
					}
				}
			}
			pq.offer(new Chicken(cr,cc,sum));
		}
	}
	public static int calc(int r1,int c1,int r2,int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
}
