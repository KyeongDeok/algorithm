import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main9019 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Node{
		String comm;
		String num;
		public Node(String num) {
			this.num = num;
		}
		public void addString() {
			
		}
	}
	static Deque <Integer> dq = new ArrayDeque<>();
	static char [] comm = {'D','S','L','R'};
	static String ans = "";
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			String [] sarr = sc.nextLine().split(" ");
			String a = sarr[0];
			String b = sarr[1];
			trans(a);
			bfs(makeString(),b);
		}
	}
	public static void bfs(String a,String b) {
		Queue <Node> q = new LinkedList<>();
		q.offer(new Node(a));
		while(!q.isEmpty()) {
			Node n = q.poll();
			String s;
			for(int i=0;i<4;i++) {
				s = exec(n.num,comm[i]);
			}
		}
	}
	public static String exec(String num,char comm) {
		String tmps = new String(num);
		int tmp;
		switch(comm) {
		case 'L':
			trans(tmps);
			dq.addLast(dq.pollFirst());
			tmps = makeString();
			dq.clear();
			break;
		case 'R':
			trans(tmps);
			dq.addFirst(dq.pollLast());
			tmps = makeString();
			dq.clear();
			break;
		case 'S':
			tmp = stoi(tmps);
			if(tmp <= 0) {
				tmps = String.valueOf(9999);
			}else {
				tmps = String.valueOf(tmp-1);
			}
			break;
		case 'D':
			tmp = stoi(tmps)*2;
			if(tmp >= 10000) {
				tmps = String.valueOf(tmp%10000);
			}else {
				tmps = String.valueOf(tmp);
			}
			break;
		}
		return tmps;
	}
	public static String makeString() {
		String s = "";
		Iterator <Integer> itr = dq.iterator();
		while(itr.hasNext()) {
			s+=String.valueOf(itr.next());
		}
		return s;
	}
	public static void trans(String num) {
		int len = num.length();
		for(int k=0;k<4-len;k++) {
			dq.offer(0);
		}
		for(int j=0;j<len;j++) {
			dq.offer(num.charAt(j) - '0');
		}
	}
}
