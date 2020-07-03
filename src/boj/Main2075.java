package boj;

import java.util.*;
import java.io.*;

public class Main2075 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		PriorityQueue <Integer> pq = new PriorityQueue<>();
		int num;
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			while(stk.hasMoreTokens()) {
				num = Integer.parseInt(stk.nextToken());
				if(pq.size() < N) {
					pq.offer(num);
				}else {
					if(pq.peek() < num ) {
						pq.poll();
						pq.offer(num);
					}
				}
			}
		}
//		Iterator it = pq.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		System.out.println(pq.poll());
	}
}
