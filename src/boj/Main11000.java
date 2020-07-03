package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main11000 {
	static class Class implements Comparable<Class>{
		int s,t;
		public Class(int s,int t) {
			this.s = s;
			this.t = t;
		}
		public int compareTo(Class c) {
			return this.t - c.t;
		}
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int s,t;
		ArrayList <Class> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			s = sc.nextInt();
			t = sc.nextInt();
			list.add(new Class(s,t));
		}
		Collections.sort(list,new Comparator<Class>() {
			public int compare(Class c1,Class c2) {
				return c1.s - c2.s;
			}
		});
		PriorityQueue <Class> q = new PriorityQueue<>();
		int len = list.size();
		for(int j=0;j<len;j++) {
			Class c = list.get(j);
			if(!q.isEmpty()) {
				if(q.peek().t > c.s) {
					q.offer(c);
				}else {
					q.poll();
					q.offer(c);
				}
			}else {
				q.offer(c);
			}
		}
		System.out.println(q.size());
		sc.close();
	}
}