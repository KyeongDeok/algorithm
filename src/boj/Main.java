package boj;

import java.util.*;
import java.io.*;

public class Main {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int N,M,K,X;
	static int INF = Integer.MAX_VALUE;
	static List <Integer> [] map;
	static int [] dist;
	static int NODE = 300001;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = stoi(stk.nextToken());
		M = stoi(stk.nextToken());
		K = stoi(stk.nextToken());
		X = stoi(stk.nextToken());
		map = new LinkedList[N+1];
		dist = new int[N+1];
		int a,b;
		for(int i=1;i<=N;i++) {
			map[i] = new LinkedList<Integer>();
		}
		for(int i=1;i<=M;i++) {
			stk = new StringTokenizer(br.readLine());
			a = stoi(stk.nextToken());
			b = stoi(stk.nextToken());
			map[a].add(b);
		}
		Arrays.fill(dist,INF);
		dist[X] = 0;
		dijk(X);
		
		//K인 노드 가져오기
		ArrayList<Integer>list = new ArrayList<>();
		for(int k=1;k<=N;k++) {
			if(dist[k] == K) {
				list.add(k);
			}
		}
		//list 정렬
		if(!list.isEmpty()) {
			Collections.sort(list);
			for(int ans : list) {
				System.out.println(ans);
			}
		}else {
			System.out.println(-1);
		}
	}
	public static void dijk(int x) {
		Queue <Integer> q = new LinkedList<>();
		q.offer(x);
		int start;
		while(!q.isEmpty()) {
			start = q.poll();
			for(int m : map[start]) {
				if(dist[m] > dist[start] + 1) {
					dist[m] = dist[start] + 1;
					q.offer(m);
 				}
			}
		}
	}
}
