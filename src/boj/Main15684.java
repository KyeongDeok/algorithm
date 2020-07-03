package boj;

import java.util.*;
import java.io.*;

public class Main15684 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,M,H;
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = stoi(stk.nextToken());
		M = stoi(stk.nextToken());
		H = stoi(stk.nextToken());
		int [][] map = new int [H+1][N];
		int a,b;
		for(int i=0;i<M;i++) {
			stk = new StringTokenizer(br.readLine());
			a = stoi(stk.nextToken());
			b = stoi(stk.nextToken());
			map[a][b] = stoi(stk.nextToken());
		}
		
		System.out.println();
	}
}
